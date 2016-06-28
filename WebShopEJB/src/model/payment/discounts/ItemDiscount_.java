package model.payment.discounts;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.payment.Bill;
import model.payment.Item;

@Generated(value="Dali", date="2016-06-27T14:46:15.308+0200")
@StaticMetamodel(ItemDiscount.class)
public class ItemDiscount_ {
	public static volatile SingularAttribute<ItemDiscount, Integer> id;
	public static volatile SingularAttribute<ItemDiscount, Bill> bill;
	public static volatile SingularAttribute<ItemDiscount, Item> item;
	public static volatile SingularAttribute<ItemDiscount, Double> discountPercentage;
	public static volatile SingularAttribute<ItemDiscount, DiscountType> type;
}
