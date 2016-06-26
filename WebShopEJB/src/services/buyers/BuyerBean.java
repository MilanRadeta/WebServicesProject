package services.buyers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import jess.JessException;
import jess.Rete;
import model.articles.Article;
import model.payment.Bill;
import model.payment.BillState;
import model.payment.Item;
import model.payment.discounts.BillDiscount;
import model.payment.discounts.ItemDiscount;
import model.payment.discounts.SaleEvent;
import model.users.Buyer;
import model.users.Role;
import model.users.User;
import services.users.UserBean;
import utils.articles.ArticleSearchQuery;
import dao.articles.ArticleDaoLocal;
import dao.payment.BillDaoLocal;
import dao.payment.discounts.SaleEventDaoLocal;
import dao.users.BuyerDaoLocal;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
@Path("/buyers")
public class BuyerBean implements BuyerBeanRemote {

	@Context
	private HttpHeaders httpHeaders;

	@EJB
	private UserBean userBean;

	@EJB
	private BuyerDaoLocal buyerDao;

	@EJB
	private ArticleDaoLocal articleDao;
	
	@EJB
	private SaleEventDaoLocal saleDao;
	
	@EJB
	private BillDaoLocal billDao;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "TEST";
	}

	@Override
	public Map<String, Object> getBuyerProfile() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.BUYER) {
			Buyer buyer = buyerDao.findById(user.getId());
			HashMap<String, Object> profile = new HashMap<>();
			profile.put("address", buyer.getAddress());
			profile.put("category", buyer.getCategory());
			profile.put("points", buyer.getPoints());
			return profile;
		}
		return null;
	}

	@Override
	public List<Bill> getPaymentHistory() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.BUYER) {
			Buyer buyer = buyerDao.findById(user.getId());
			return buyer.getPaymentHistory();
		}
		return null;
	}

	@Override
	public List<Article> searchArticle(ArticleSearchQuery query) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.BUYER) {
			List<Article> articles = articleDao.findByQuery(query);
			return articles;
		}
		return null;
	}

	@Override
	public Bill getNewBill() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.BUYER) {
			return new Bill();
		}
		return null;
	}

	@Override
	public Bill saveBill(Bill bill) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.BUYER) {
			Buyer buyer = buyerDao.findById(user.getId());
			List<Article> articles = new ArrayList<>();
			int itemNumber = 0;
			for (Item item : bill.getItems()) {
				Article article = item.getArticle();
				article = articleDao.findById(article.getId());
				articles.add(article);
				item.setArticle(article);
				item.setBill(bill);
				item.setItemNumber(++itemNumber);
				item.setUnitPrice(article.getPrice());
			}
			bill.setState(BillState.ORDERED);
			bill.setDate(new Date());
			bill.setBuyer(buyer);
			bill.setTotalPrice(0);
			bill.setOriginalTotalPrice(0);
			return formBill(bill);
		}
		return null;
	}
	
	@Override
	public Bill payBill(Bill bill) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.BUYER) {
			Buyer buyer = buyerDao.findById(user.getId());
			List<Article> articles = new ArrayList<>();
			int itemNumber = 0;
			for (Item item : bill.getItems()) {
				Article article = item.getArticle();
				article = articleDao.findById(article.getId());
				articles.add(article);
				item.setArticle(article);
				item.setBill(bill);
				item.setItemNumber(++itemNumber);
				item.setUnitPrice(article.getPrice());
			}
			bill.setState(BillState.ORDERED);
			bill.setDate(new Date());
			bill.setBuyer(buyer);
			bill.setTotalPrice(0);
			bill.setOriginalTotalPrice(0);
			bill = formBill(bill);
			buyer.getPaymentHistory().add(bill);

			billDao.persistBillWithReferences(bill);
			return bill;
		}
		return null;
	}

	@Override
	public List<SaleEvent> getSaleEvents() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.BUYER) {
			return saleDao.findAll();
		}
		return null;
	}
	

	private Bill formBill(Bill bill) {

		for (Item item : bill.getItems()) {
			item.setDiscountPercentage(0);
			item.getDiscounts().clear();
			item.setOriginalTotalPrice(0);
			item.setTotalPrice(0);
		}
		try {
			Rete engine = new Rete();
			engine.reset();
			engine.eval("(watch all)");
			engine.batch("jess/rules/baseItemDiscounts.clp");
			for (Item item : bill.getItems()) {
				engine.definstance("articleCategory", item.getArticle().getArticleCategory(), false);
				engine.definstance("article", item.getArticle(), false);
				engine.definstance("item", item, false);
			}
			engine.definstance("bill", bill, false);
			engine.run();

			engine = new Rete();
			engine.reset();
			engine.eval("(watch all)");
			engine.batch("jess/rules/additionalItemDiscounts.clp");
			for (Item item : bill.getItems()) {
				engine.definstance("article", item.getArticle(), false);
				engine.definstance("item", item, false);
			}
			engine.definstance("bill", bill, false);
			
			for (Bill oldBill : bill.getBuyer().getPaymentHistory()) {
				for (Item item : oldBill.getItems()) {
					engine.definstance("article", item.getArticle(), false);
					engine.definstance("item", item, false);
				}
				engine.definstance("bill", oldBill, false);
			}
			
			for (SaleEvent sale : saleDao.findAll()) {
				engine.definstance("saleEvent", sale, false);
			}
			
			engine.run();
			
			engine = new Rete();
			engine.reset();
			engine.eval("(watch all)");
			engine.batch("jess/rules/finalItemDiscounts.clp");
			for (Item item : bill.getItems()) {
				engine.definstance("articleCategory", item.getArticle().getArticleCategory(), false);
				engine.definstance("article", item.getArticle(), false);
				for (ItemDiscount discount : item.getDiscounts()) {
					engine.definstance("itemDiscount", discount, false);
				}
				engine.definstance("item", item, false);
			}
			engine.definstance("bill", bill, false);
			
			engine.run();
			
			engine = new Rete();
			engine.reset();
			engine.eval("(watch all)");
			engine.batch("jess/rules/billDiscounts.clp");
			engine.definstance("buyerCategory", bill.getBuyer().getCategory(), false);
			engine.definstance("buyer", bill.getBuyer(), false);
			for (Item item : bill.getItems()) {
				engine.definstance("articleCategory", item.getArticle().getArticleCategory(), false);
				engine.definstance("article", item.getArticle(), false);
				engine.definstance("item", item, false);
			}
			engine.definstance("bill", bill, false);
			
			engine.run();
			
			engine = new Rete();
			engine.reset();
			engine.eval("(watch all)");
			engine.batch("jess/rules/finalBillDiscounts.clp");
			engine.definstance("bill", bill, false);
			for (BillDiscount discount : bill.getDiscounts()) {
				engine.definstance("billDiscount", discount, false);
			}
			
			engine.run();
			
			engine = new Rete();
			engine.reset();
			engine.eval("(watch all)");
			engine.batch("jess/rules/points.clp");
			engine.definstance("buyerCategory", bill.getBuyer().getCategory(), false);
			engine.definstance("buyer", bill.getBuyer(), false);
			engine.definstance("bill", bill, false);
			
			engine.run();
			
		} catch (JessException e) {
			e.printStackTrace();
			return null;
		}
		return bill;
	}


}
