package model.payment;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.payment.discounts.BillDiscount;
import model.users.Buyer;

@Generated(value="Dali", date="2016-06-28T03:38:03.978+0200")
@StaticMetamodel(Bill.class)
public class Bill_ {
	public static volatile SingularAttribute<Bill, Integer> id;
	public static volatile SingularAttribute<Bill, Date> date;
	public static volatile SingularAttribute<Bill, Buyer> buyer;
	public static volatile SingularAttribute<Bill, BillState> state;
	public static volatile SingularAttribute<Bill, Double> originalTotalPrice;
	public static volatile SingularAttribute<Bill, Double> discountPercentage;
	public static volatile SingularAttribute<Bill, Double> totalPrice;
	public static volatile SingularAttribute<Bill, Integer> spentPoints;
	public static volatile SingularAttribute<Bill, Integer> receivedPoints;
	public static volatile ListAttribute<Bill, BillDiscount> discounts;
	public static volatile ListAttribute<Bill, Item> items;
}
