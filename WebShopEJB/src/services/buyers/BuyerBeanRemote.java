package services.buyers;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.articles.Article;
import model.articles.ArticleCategory;
import model.payment.Bill;
import model.payment.discounts.SaleEvent;
import utils.articles.ArticleSearchQuery;

@Remote
public interface BuyerBeanRemote {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/profile")
	public Map<String, Object> getBuyerProfile();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/paymentHistory")
	public List<Bill> getPaymentHistory();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/articles")
	public List<ArticleCategory> getArticleCategories();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/articles")
	public List<Article> searchArticle(ArticleSearchQuery query);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saleEvents")
	public List<SaleEvent> getSaleEvents();

	@GET
	@Produces
	@Path("/cart")
	public Bill getNewBill();

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cart")
	public Bill saveBill(Bill bill);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/bill")
	public Bill payBill(Bill bill);

}
