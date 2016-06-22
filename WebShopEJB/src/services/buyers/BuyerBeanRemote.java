package services.buyers;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import model.articles.Article;
import model.payment.Bill;
import utils.articles.ArticleResult;
import utils.articles.ArticleSearchQuery;
import utils.shoppingcart.ShoppingCart;

@Remote
public interface BuyerBeanRemote {

	// TODO: REST annotations

	public Map<String, Object> getBuyerProfile();

	public List<Bill> getPaymentHistory();

	public List<ArticleResult> searchArticle(ArticleSearchQuery query);

	public ShoppingCart addItemToCart(Article article, int count);

	public Bill formBill();

	public Bill payBill(int spentPoints);

}
