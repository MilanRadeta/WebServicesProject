package services.managers;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.articles.ArticleCategory;
import model.payment.discounts.SaleEvent;
import model.users.buyers.BuyerCategory;

@Remote
public interface ManagerBeanRemote {
	// Buyer Categories
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buyerCategories")
	public List<BuyerCategory> getBuyerCategories();

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/buyerCategories")
	public String changeBuyerCategory(BuyerCategory category);

	// Article Categories
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/articleCategories")
	public String addArticleCategory(ArticleCategory category);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/articleCategories")
	public List<ArticleCategory> getArticleCategories();

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/articleCategories")
	public String changeArticleCategory(ArticleCategory category);

	// Sales Events

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/saleEvents")
	public String createSale(SaleEvent event);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saleEvents")
	public List<SaleEvent> getSales();

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/saleEvents")
	public String changeSale(SaleEvent event);
	
}
