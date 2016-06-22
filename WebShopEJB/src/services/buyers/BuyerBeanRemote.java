package services.buyers;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.articles.Article;
import model.payment.Bill;
import utils.articles.ArticleResult;
import utils.articles.ArticleSearchQuery;
import utils.shoppingcart.ShoppingCart;

@Remote
public interface BuyerBeanRemote {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBuyerProfile")
	public Map<String, Object> getBuyerProfile();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPaymentHistory")
	public List<Bill> getPaymentHistory();

	// TODO: change to work with get method
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ArticleResult> searchArticle(ArticleSearchQuery query);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addItemToCart")
	public ShoppingCart addItemToCart(Article article, @QueryParam("count") int count);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/formBill")
	public Bill formBill();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/payBill")
	public Bill payBill(int spentPoints);

}
