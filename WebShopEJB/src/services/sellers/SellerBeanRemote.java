package services.sellers;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
	@Path("/articles")
	public List<Article> checkArticles();

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/articles")
	public void orderArticle(Article article, @QueryParam("count") int count);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/bills")
	public List<Bill> getOrderedBills();

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/bills")
	public List<Item> processBill(Bill bill);

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/bills")
	public void cancelBill(Bill bill);
	
}
