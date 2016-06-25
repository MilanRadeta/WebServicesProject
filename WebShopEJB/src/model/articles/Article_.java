package model.articles;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-25T15:14:02.024+0200")
@StaticMetamodel(Article.class)
public class Article_ {
	public static volatile SingularAttribute<Article, Integer> id;
	public static volatile SingularAttribute<Article, String> name;
	public static volatile SingularAttribute<Article, ArticleCategory> articleCategory;
	public static volatile SingularAttribute<Article, Double> price;
	public static volatile SingularAttribute<Article, Double> inStock;
	public static volatile SingularAttribute<Article, Date> creationDate;
	public static volatile SingularAttribute<Article, Boolean> neededInStock;
	public static volatile SingularAttribute<Article, ArticleStatus> status;
	public static volatile SingularAttribute<Article, Double> minInStock;
}
