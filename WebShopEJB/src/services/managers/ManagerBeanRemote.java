package services.managers;

import java.util.List;

import javax.ejb.Remote;

import model.articles.ArticleCategory;
import model.payment.discounts.SaleEvent;
import model.users.buyers.BuyerCategory;

@Remote
public interface ManagerBeanRemote {

	// TODO: rest annotations
	
	public List<BuyerCategory> getBuyerCategories();
	
	public String changeBuyerCategory(BuyerCategory category);
	
	public String addArticleCategory(ArticleCategory category, boolean hasParent);
	
	public List<ArticleCategory> getArticleCategories();
	
	public String changeArticleCategory(ArticleCategory category);
	
	public void createSale(SaleEvent event);
	
	public List<SaleEvent> getSales();
	
	public String changeSale(SaleEvent event);
	
}
