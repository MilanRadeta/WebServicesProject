package services.sellers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import jess.Filter;
import jess.JessException;
import jess.Rete;
import model.articles.Article;
import model.payment.Bill;
import model.payment.BillState;
import model.payment.Item;
import model.users.Role;
import model.users.User;
import services.users.UserBean;
import dao.articles.ArticleDaoLocal;
import dao.payment.BillDaoLocal;

/**
 * Session Bean implementation class SellerBean
 */
@Stateless
@LocalBean
@Path("/sellers")
public class SellerBean implements SellerBeanRemote {

	@Context
	private HttpHeaders httpHeaders;

	@EJB
	private UserBean userBean;

	@EJB
	private ArticleDaoLocal articleDao;

	@EJB
	private BillDaoLocal billDao;

	@Override
	public List<Article> checkArticles() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.SELLER) {
			List<Article> articles = articleDao.findAll();
			List<Article> retVal = new ArrayList<>();
			try {
				Rete engine = new Rete();
				engine.reset();
				engine.eval("(watch all)");
				engine.batch("jess/rules/articles.clp");

				for (Article article : articles) {
					if (article.isNeededInStock()) {
						retVal.add(article);
					} else {
						engine.definstance("article", article, false);
					}
				}
				engine.run();
				@SuppressWarnings("unchecked")
				Iterator<Article> iterator = engine.getObjects(new Filter() {

					@Override
					public boolean accept(Object arg0) {
						if (arg0 instanceof Article) {
							Article article = (Article) arg0;
							if (article.isNeededInStock()) {
								return true;
							}
						}
						return false;
					}
				});
				while (iterator.hasNext()) {
					Article article = iterator.next();
					articleDao.merge(article);
					retVal.add(article);
				}
				return retVal;
			} catch (JessException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public void orderArticle(Article article, int count) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.SELLER) {
			Article dbArticle = articleDao.findById(article.getId());
			dbArticle.setInStock(dbArticle.getInStock() + count);
			if (dbArticle.getInStock() > dbArticle.getMinInStock()) {
				dbArticle.setNeededInStock(false);
			}
			articleDao.merge(dbArticle);
		}
	}

	@Override
	public List<Bill> getOrderedBills() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.SELLER) {
			return billDao.findOrderedBills();
		}
		return null;
	}

	@Override
	public List<Item> processBill(Bill bill) {
		List<Item> missingItems = new ArrayList<>();
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.SELLER) {
			Bill dbBill = billDao.findById(bill.getId());
			List<Article> articles = new ArrayList<>();
			List<Item> allItems = dbBill.getItems();
			Set<Item> dedupeItems = new LinkedHashSet<>(allItems);
			allItems.clear();
			allItems.addAll(dedupeItems);
			for (Item item : allItems) {
				double units = item.getUnits();
				Article article = item.getArticle();
				double inStock = article.getInStock();
				if (units > inStock) {
					missingItems.add(item);
				} else {
					article.setInStock(inStock - units);
					articles.add(article);
				}
			}
			if (missingItems.isEmpty()) {
				for (Article article : articles) {
					articleDao.merge(article);
				}
				dbBill.setState(BillState.SUCCESSFULLY_REALIZED);
				billDao.merge(dbBill);
			}
		}
		return missingItems;
	}

	@Override
	public void cancelBill(int id) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.SELLER) {
			Bill dbBill = billDao.findById(id);
			dbBill.setState(BillState.CANCELED);
			billDao.merge(dbBill);
		}
	}

}
