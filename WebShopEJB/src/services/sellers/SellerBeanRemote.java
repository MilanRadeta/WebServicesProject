package services.sellers;

import java.util.List;

import javax.ejb.Remote;

import model.articles.Article;
import model.payment.Bill;
import model.payment.Item;

@Remote
public interface SellerBeanRemote {

	// TODO: REST annotations
	
	public List<Article> checkArticles();
	
	public void orderArticle(Article article, int count);
	
	public List<Bill> getOrderedBills();
	
	public List<Item> processBill(Bill bill);
	
	public void cancelBill(Bill bill);
	
}
