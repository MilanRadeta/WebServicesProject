package model.users;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.payment.Bill;
import model.users.buyers.BuyerCategory;

@Generated(value="Dali", date="2016-06-25T15:14:02.070+0200")
@StaticMetamodel(Buyer.class)
public class Buyer_ extends User_ {
	public static volatile SingularAttribute<Buyer, String> address;
	public static volatile SingularAttribute<Buyer, Double> points;
	public static volatile SingularAttribute<Buyer, BuyerCategory> category;
	public static volatile ListAttribute<Buyer, Bill> paymentHistory;
}
