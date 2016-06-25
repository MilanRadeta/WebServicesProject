package model.users.buyers;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-25T15:14:02.074+0200")
@StaticMetamodel(PaymentPointsBonus.class)
public class PaymentPointsBonus_ {
	public static volatile SingularAttribute<PaymentPointsBonus, Integer> id;
	public static volatile SingularAttribute<PaymentPointsBonus, Double> min;
	public static volatile SingularAttribute<PaymentPointsBonus, Double> max;
	public static volatile SingularAttribute<PaymentPointsBonus, Double> percent;
	public static volatile SingularAttribute<PaymentPointsBonus, BuyerCategory> buyerCategory;
}
