package model.articles;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-27T14:46:15.289+0200")
@StaticMetamodel(ArticleCategory.class)
public class ArticleCategory_ {
	public static volatile SingularAttribute<ArticleCategory, Integer> id;
	public static volatile SingularAttribute<ArticleCategory, String> code;
	public static volatile SingularAttribute<ArticleCategory, Boolean> consumerArticle;
	public static volatile SingularAttribute<ArticleCategory, String> name;
	public static volatile SingularAttribute<ArticleCategory, Double> maxDiscount;
}
