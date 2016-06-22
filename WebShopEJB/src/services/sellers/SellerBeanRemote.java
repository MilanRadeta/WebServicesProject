package services.sellers;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.articles.Article;
import model.payment.Bill;
import model.payment.Item;

@Remote
public interface SellerBeanRemote {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/checkArticles")
	public List<Article> checkArticles();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/orderArticle")
	public void orderArticle(Article article, @QueryParam("count") int count);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getOrderedBills")
	public List<Bill> getOrderedBills();

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/processBill")
	public List<Item> processBill(Bill bill);

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cancelBill")
	public void cancelBill(Bill bill);
	
}
