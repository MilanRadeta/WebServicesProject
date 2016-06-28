package model.payment;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.articles.Article;
import model.payment.discounts.ItemDiscount;

@Generated(value="Dali", date="2016-06-28T03:38:04.025+0200")
@StaticMetamodel(Item.class)
public class Item_ {
	public static volatile SingularAttribute<Item, Integer> id;
	public static volatile SingularAttribute<Item, Bill> bill;
	public static volatile SingularAttribute<Item, Integer> itemNumber;
	public static volatile SingularAttribute<Item, Article> article;
	public static volatile SingularAttribute<Item, Double> unitPrice;
	public static volatile SingularAttribute<Item, Double> units;
	public static volatile SingularAttribute<Item, Double> originalTotalPrice;
	public static volatile SingularAttribute<Item, Double> discountPercentage;
	public static volatile SingularAttribute<Item, Double> totalPrice;
	public static volatile ListAttribute<Item, ItemDiscount> discounts;
}
