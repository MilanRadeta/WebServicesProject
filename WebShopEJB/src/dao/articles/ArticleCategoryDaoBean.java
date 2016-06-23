package dao.articles;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.articles.ArticleCategory;
import dao.GenericDaoBean;

@Stateless
@Local(ArticleCategoryDaoLocal.class)
public class ArticleCategoryDaoBean extends GenericDaoBean<ArticleCategory, Integer> implements ArticleCategoryDaoLocal {
	
}
