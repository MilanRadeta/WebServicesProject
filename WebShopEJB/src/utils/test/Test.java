package utils.test;

import jess.JessException;
import jess.Rete;
import model.articles.Article;
import model.payment.Bill;
import model.payment.Item;
import model.users.Buyer;
import model.users.Role;

public class Test {
	

	// TODO: test billItems rules
	
	public static void main(String[] args) {
		try {
			Rete engine = new Rete();
			engine.reset();
			engine.eval("(watch all)");
			engine.batch("jess/templates/templates.clp");
			
			Buyer buyer = new Buyer();
			buyer.setUsername("testUsername");
			
			Bill bill = new Bill();
			bill.setBuyer(buyer);
			
			Item item = new Item();
			item.setBill(bill);
			
			Article article = new Article();
			article.setId(1);
			item.setArticle(article);
			
			bill.getItems().add(item);
			System.out.println(Role.BUYER.toString());
			System.out.println(Role.BUYER.name());
			engine.definstance("buyer", buyer, false);
			engine.definstance("bill", bill, false);
			engine.definstance("article", article, false);
			engine.definstance("item", item, false);
			engine.eval("(bind ?f (fact-id 1) )");
			engine.eval("(printout t ?f crlf)");
			engine.eval("(printout t ?f.role crlf)");
			engine.eval("(printout t Role.BUYER crlf)");
			engine.eval("(printout t (get-member Role BUYER) crlf)");
			engine.eval("(printout t (call ?f.role toString) crlf)");
			engine.eval("(printout t (= ?f.role (get-member Role BUYER)) crlf)");
			engine.eval("(facts)");
			
			
		} catch (JessException e) {
			e.printStackTrace();
		}
	}

}
