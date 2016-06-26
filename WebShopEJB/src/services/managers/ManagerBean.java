package services.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import model.articles.ArticleCategory;
import model.payment.discounts.SaleEvent;
import model.users.Role;
import model.users.User;
import model.users.buyers.BuyerCategory;
import services.users.UserBean;
import dao.articles.ArticleCategoryDaoLocal;
import dao.payment.discounts.SaleEventDaoLocal;
import dao.users.buyers.BuyerCategoryDaoLocal;
import dao.users.buyers.PaymentPointsBonusDaoLocal;

/**
 * Session Bean implementation class ManagerBean
 */
@Stateless
@LocalBean
@Path("/managers")
public class ManagerBean implements ManagerBeanRemote {

	@Context
	private HttpHeaders httpHeaders;

	@EJB
	private UserBean userBean;

	@EJB
	private BuyerCategoryDaoLocal buyerCategoryDao;

	@EJB
	private PaymentPointsBonusDaoLocal pointsDao;

	@EJB
	private ArticleCategoryDaoLocal articleCategoryDao;
	
	@EJB
	private SaleEventDaoLocal saleDao;

	// TODO: all entities must eagerly fetch

	@Override
	public List<BuyerCategory> getBuyerCategories() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			List<BuyerCategory> categories = buyerCategoryDao.findAll();
			return categories;
		}
		return null;
	}

	@Override
	public String changeBuyerCategory(BuyerCategory category) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			buyerCategoryDao.saveBuyerCategory(category);
		}
		return null;
	}

	@Override
	public String addArticleCategory(ArticleCategory category) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			articleCategoryDao.persist(category);
		}
		return null;

	}

	@Override
	public List<ArticleCategory> getArticleCategories() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			return articleCategoryDao.findAll();
		}
		return null;
	}

	@Override
	public String changeArticleCategory(ArticleCategory category) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			ArticleCategory dbCategory = articleCategoryDao.findById(category.getId());
			if (dbCategory != null && dbCategory.getCode().equals(category.getCode())) {
				articleCategoryDao.merge(category);
				return null;
			}
		}
		return null;
	}

	@Override
	public String createSale(SaleEvent event) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			saleDao.persist(event);
		}
		return null;
	}

	@Override
	public List<SaleEvent> getSales() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			return saleDao.findAll();
		}
		return null;
	}

	@Override
	public String changeSale(SaleEvent event) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders()
				.getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			if (event.getActionFrom().before(event.getActionTo())) {
				saleDao.merge(event);
			}
		}
		return null;
	}

}
