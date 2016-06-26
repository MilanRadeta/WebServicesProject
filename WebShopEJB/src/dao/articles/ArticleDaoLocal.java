package dao.articles;

import java.util.List;

import utils.articles.ArticleSearchQuery;
import model.articles.Article;
import dao.GenericDaoLocal;

public interface ArticleDaoLocal extends GenericDaoLocal<Article, Integer> {

	public List<Article> findByQuery(ArticleSearchQuery query);
}
