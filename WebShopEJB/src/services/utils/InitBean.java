package services.utils;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

import model.articles.Article;
import model.articles.ArticleCategory;
import model.articles.ArticleStatus;
import model.users.Buyer;
import model.users.Manager;
import model.users.Seller;
import model.users.User;
import model.users.buyers.BuyerCategory;
import model.users.buyers.PaymentPointsBonus;
import utils.articles.ArticleCategoryCreator;
import utils.users.BuyerCategoryCreator;
import dao.articles.ArticleCategoryDaoLocal;
import dao.articles.ArticleDaoLocal;
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
	
	@EJB
	private ArticleDaoLocal articleDao;

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
			for (PaymentPointsBonus bonus : buyerCategory
					.getPaymentPointsBonuses()) {
				pointsDao.persist(bonus);
			}
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

		List<ArticleCategory> articleCategories = ArticleCategoryCreator
				.createCategories();
		for (ArticleCategory articleCategory : articleCategories) {

			articleCategoryDao.persist(articleCategory);

		}

		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			Article article = new Article();

			article.setArticleCategory(articleCategories.get(random
					.nextInt(articleCategories.size())));

			GregorianCalendar gc = new GregorianCalendar();

			int year = randBetween(1900, 2010);

			gc.set(GregorianCalendar.YEAR, year);

			int dayOfYear = randBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));

			gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);

			article.setCreationDate(gc.getTime());
			article.setInStock(random.nextDouble() * 100);
			article.setMinInStock(random.nextDouble() * 50);
			article.setName("Artikl " + i);
			article.setCode("TST" + i);
			article.setPrice(random.nextDouble() * 1000);
			article.setStatus(ArticleStatus.values()[random.nextInt(ArticleStatus.values().length)]);
			articleDao.persist(article);
		}

	}

	private int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
