package dao.articles;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.articles.Article;
import dao.GenericDaoBean;

@Stateless
@Local(ArticleDaoLocal.class)
public class ArticleDaoBean extends GenericDaoBean<Article, Integer> implements ArticleDaoLocal {
	
}
