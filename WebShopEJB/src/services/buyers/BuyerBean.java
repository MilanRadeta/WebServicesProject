package services.buyers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

import model.articles.Article;
import model.payment.Bill;
import model.payment.Item;
import model.users.Buyer;
import utils.articles.ArticleResult;
import utils.articles.ArticleSearchQuery;
import utils.shoppingcart.ShoppingCart;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
@Path("/buyers")
public class BuyerBean implements BuyerBeanRemote {

	@Override
	public Map<String, Object> getBuyerProfile() {
		// TODO: get user with tokens
		Buyer buyer = new Buyer();
		HashMap<String, Object> profile = new HashMap<>();
		profile.put("address", buyer.getAddress());
		profile.put("category", buyer.getCategory());
		profile.put("points", buyer.getPoints());
		return profile;
	}

	@Override
	public List<Bill> getPaymentHistory() {
		// TODO: get user with tokens
		Buyer buyer = new Buyer();
		return buyer.getPaymentHistory();
	}

	@Override
	public List<ArticleResult> searchArticle(ArticleSearchQuery query) {
		List<ArticleResult> articles = new ArrayList<ArticleResult>();
		// TODO: form a query and search the database
		// TODO: search only active articles
		return articles;
	}

	@Override
	public ShoppingCart addItemToCart(Article article, int count) {
		// TODO: get user with tokens
		Buyer buyer = new Buyer();
		// TODO: get buyers shopping cart
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.getItems().put(article, count);
		return shoppingCart;
	}

	// TODO: user only needs items, original total price, calculated total
	// price, maybe use util class
	@Override
	public Bill formBill() {
		// TODO: get user with tokens
		Buyer buyer = new Buyer();
		// TODO: get shopping cart
		ShoppingCart cart = new ShoppingCart();
		// TODO: get articles in cart from database
		List<Article> articles = new ArrayList<>();
		Bill bill = new Bill();
		bill.setDate(new Date());
		List<Item> items = new ArrayList<>();
		int itemNumber = 0;
		for (Article article : cart.getItems().keySet()) {
			int count = cart.getItems().get(article);
			Item item = new Item();
			item.setArticle(article);
			item.setBill(bill);
			item.setItemNumber(++itemNumber);
			item.setUnitPrice(article.getPrice());
			item.setUnits(count);
		}
		bill.setItems(items);
		// TODO: use Rete engine to calculate prices
		// TODO: get sales events
		// bill.setTotalPrice(0);
		// bill.setOriginalTotalPrice(0);
		return null;
	}

	@Override
	public Bill payBill(int spentPoints) {

		// TODO: get user with tokens
		Buyer buyer = new Buyer();
		// TODO: get shopping cart
		ShoppingCart cart = new ShoppingCart();
		// TODO: get articles in cart from database
		List<Article> articles = new ArrayList<>();
		Bill bill = new Bill();
		bill.setDate(new Date());
		List<Item> items = new ArrayList<>();
		int itemNumber = 0;
		for (Article article : cart.getItems().keySet()) {
			int count = cart.getItems().get(article);
			Item item = new Item();
			item.setArticle(article);
			item.setBill(bill);
			item.setItemNumber(++itemNumber);
			item.setUnitPrice(article.getPrice());
			item.setUnits(count);
			// TODO: use Rete engine to calculate discounts and prices
		}
		bill.setItems(items);
		bill.setSpentPoints(spentPoints);
		// TODO: use Rete engine to calculate everything else in the bill
		buyer.getPaymentHistory().add(bill);
		// TODO: persist
		return bill;
	}

}
