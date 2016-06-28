package model.users;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.payment.Bill;
import model.users.buyers.BuyerCategory;

@Generated(value="Dali", date="2016-06-27T14:46:15.387+0200")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, Role> role;
	public static volatile SingularAttribute<User, Date> registrationDate;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, Double> points;
	public static volatile SingularAttribute<User, BuyerCategory> category;
	public static volatile ListAttribute<User, Bill> paymentHistory;
}
