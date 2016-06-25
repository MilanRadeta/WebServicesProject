package model.payment.discounts;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.articles.ArticleCategory;

@Generated(value="Dali", date="2016-06-25T15:14:02.068+0200")
@StaticMetamodel(SaleEvent.class)
public class SaleEvent_ {
	public static volatile SingularAttribute<SaleEvent, Integer> id;
	public static volatile SingularAttribute<SaleEvent, String> name;
	public static volatile SingularAttribute<SaleEvent, Date> actionFrom;
	public static volatile SingularAttribute<SaleEvent, Date> actionTo;
	public static volatile SingularAttribute<SaleEvent, Double> discount;
	public static volatile ListAttribute<SaleEvent, ArticleCategory> categories;
}
