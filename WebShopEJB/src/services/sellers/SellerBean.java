package services.sellers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

import model.articles.Article;
import model.payment.Bill;
import model.payment.BillState;
import model.payment.Item;

/**
 * Session Bean implementation class SellerBean
 */
@Stateless
@LocalBean
@Path("/sellers")
public class SellerBean implements SellerBeanRemote {

	@Override
	public List<Article> checkArticles() {
		// TODO: check if seller is logged in
		// TODO: get Articles from database
		List<Article> articles = new ArrayList<Article>();
		// TODO: use RETE engine to check all articles if they're needed in stock
		// TODO: use RETE engine to get all articles that are needed in stock
		articles = new ArrayList<Article>();
		return articles;
	}

	@Override
	public void orderArticle(Article article, int count) {
		// TODO: check if seller is logged in
		// TODO: get Article from database
		article.setInStock(article.getInStock() + count);
		if (article.getInStock() > article.getMinInStock()) {
			article.setNeededInStock(false);
		}
		// TODO: persist
	}

	@Override
	public List<Bill> getOrderedBills() {
		// TODO: check if seller is logged in
		// TODO: get ordered bills from database
		List<Bill> orderedBills = new ArrayList<>();
		return orderedBills;
	}

	@Override
	public List<Item> processBill(Bill bill) {
		// TODO: check if seller is logged in
		// TODO: get bill from database
		// TODO: use RETE engine?
		List<Item> missingItems  = new ArrayList<>();
		for (Item item : bill.getItems()) {
			double units = item.getUnits();
			Article article = item.getArticle();
			double inStock = article.getInStock();
			if (units > inStock) {
				missingItems.add(item);
			}
			else {
				article.setInStock(inStock - units);
			}
		}
		if (missingItems.isEmpty()) {
			// TODO: persist
		}
		return missingItems;
	}

	@Override
	public void cancelBill(Bill bill) {
		// TODO: check if seller is logged in
		// TODO: get bill from database
		bill.setState(BillState.CANCELED);
		// TODO: persist
	}

	

}
