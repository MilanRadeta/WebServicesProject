package model.users.buyers;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-28T03:38:04.056+0200")
@StaticMetamodel(BuyerCategory.class)
public class BuyerCategory_ {
	public static volatile SingularAttribute<BuyerCategory, Integer> id;
	public static volatile SingularAttribute<BuyerCategory, String> name;
	public static volatile ListAttribute<BuyerCategory, PaymentPointsBonus> paymentPointsBonuses;
}
