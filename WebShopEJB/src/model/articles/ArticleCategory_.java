package model.articles;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-25T15:14:02.062+0200")
@StaticMetamodel(ArticleCategory.class)
public class ArticleCategory_ {
	public static volatile SingularAttribute<ArticleCategory, Integer> id;
	public static volatile SingularAttribute<ArticleCategory, ArticleCategory> parentCategory;
	public static volatile SingularAttribute<ArticleCategory, String> name;
	public static volatile SingularAttribute<ArticleCategory, Double> maxDiscount;
}
