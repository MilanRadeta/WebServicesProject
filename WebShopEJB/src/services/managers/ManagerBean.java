package services.managers;

import java.util.ArrayList;
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
	
	// TODO: all entities must eagerly fetch
	
	@Override
	public List<BuyerCategory> getBuyerCategories() {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders().getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			List<BuyerCategory> categories = buyerCategoryDao.findAll();
			return categories;
		}
		return null;
	}

	@Override
	public String changeBuyerCategory(BuyerCategory category) {
		User user = userBean.validateJWTToken(httpHeaders.getRequestHeaders().getFirst("Authorization"));
		if (user != null && user.getRole() == Role.MANAGER) {
			buyerCategoryDao.saveBuyerCategory(category);
		}
		return null;
	}

	@Override
	public String addArticleCategory(ArticleCategory category) {
		// TODO: check if manager is logged in
		// TODO: if id exists return error message
		// TODO: persist
		return null;
		
	}

	@Override
	public List<ArticleCategory> getArticleCategories() {
		// TODO: check if manager is logged in
		// TODO: get categories from database
		List<ArticleCategory> categories = new ArrayList<ArticleCategory>();
		return categories;
	}

	@Override
	public String changeArticleCategory(ArticleCategory category) {
		// TODO: check if manager is logged in
		// TODO: get category from DB
		// TODO: if exists overwrite and persist, else return error
		return null;
	}

	@Override
	public String createSale(SaleEvent event) {
		// TODO: check if manager is logged in
		// TODO: if id exists return error message
		// TODO: persist
		return null;
	}

	@Override
	public List<SaleEvent> getSales() {
		// TODO: check if manager is logged in
		// TODO: get sales from database
		List<SaleEvent> categories = new ArrayList<SaleEvent>();
		return categories;
	}

	@Override
	public String changeSale(SaleEvent event) {
		// TODO: check if manager is logged in
		// TODO: get sale from DB
		// TODO: if exists overwrite and persist, else return error
		return null;
	}

	

}
