package model.payment.discounts;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.payment.Bill;

@Generated(value="Dali", date="2016-06-28T03:38:03.994+0200")
@StaticMetamodel(BillDiscount.class)
public class BillDiscount_ {
	public static volatile SingularAttribute<BillDiscount, Integer> id;
	public static volatile SingularAttribute<BillDiscount, Bill> bill;
	public static volatile SingularAttribute<BillDiscount, Double> discountPercentage;
	public static volatile SingularAttribute<BillDiscount, DiscountType> type;
}
