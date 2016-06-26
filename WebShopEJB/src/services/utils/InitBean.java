package services.utils;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

import model.articles.ArticleCategory;
import model.users.Buyer;
import model.users.Manager;
import model.users.Seller;
import model.users.User;
import model.users.buyers.BuyerCategory;
import model.users.buyers.PaymentPointsBonus;
import utils.articles.ArticleCategoryCreator;
import utils.users.BuyerCategoryCreator;
import dao.articles.ArticleCategoryDaoLocal;
import dao.users.BuyerDaoLocal;
import dao.users.UserDaoLocal;
import dao.users.buyers.BuyerCategoryDaoLocal;
import dao.users.buyers.PaymentPointsBonusDaoLocal;

/**
 * Session Bean implementation class SellerBean
 */
@Stateless
@LocalBean
@Path("/init")
public class InitBean implements InitBeanRemote {

	@EJB
	private UserDaoLocal userDao;

	@EJB
	private BuyerDaoLocal buyerDao;

	@EJB
	private BuyerCategoryDaoLocal buyerCategoryDao;

	@EJB
	private PaymentPointsBonusDaoLocal pointsDao;
	
	@EJB
	private ArticleCategoryDaoLocal articleCategoryDao;

	public void createDatabase() {
		System.out.println("createDatabase");
		User user = new Manager();
		user.setFirstName("Manuel");
		user.setLastName("Manager");
		user.setUsername("manuel");
		user.setPassword("yosoymanager");
		user.setRegistrationDate(new Date());

		userDao.persist(user);

		user = new Seller();
		user.setFirstName("Salvador");
		user.setLastName("Seller");
		user.setUsername("salvador");
		user.setPassword("muchotrabajo");
		user.setRegistrationDate(new Date());

		userDao.persist(user);

		List<BuyerCategory> buyerCategories = BuyerCategoryCreator
				.createCategories();
		for (BuyerCategory buyerCategory : buyerCategories) {

			buyerCategoryDao.persist(buyerCategory);
			for (PaymentPointsBonus bonus : buyerCategory.getPaymentPointsBonuses()) {
				pointsDao.persist(bonus);
			}
		}

		List<ArticleCategory> articleCategories = ArticleCategoryCreator
				.createCategories();
		for (ArticleCategory articleCategory : articleCategories) {

			articleCategoryDao.persist(articleCategory);

		}

		Buyer buyer = new Buyer();
		buyer.setFirstName("Bernardo");
		buyer.setLastName("Buyer");
		buyer.setUsername("bernardo");
		buyer.setPassword("pocodinero");
		buyer.setRegistrationDate(new Date());
		buyer.setAddress("Calle del Diablo 666, Guadalajara");
		buyer.setCategory(buyerCategories.get(0));

		buyerDao.persist(buyer);
		System.out.println("Finished");

	}

}
