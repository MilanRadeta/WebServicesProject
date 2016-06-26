package dao.articles;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import utils.articles.ArticleSearchQuery;
import model.articles.Article;
import model.articles.ArticleCategory;
import dao.GenericDaoBean;

@Stateless
@Local(ArticleDaoLocal.class)
public class ArticleDaoBean extends GenericDaoBean<Article, Integer> implements
		ArticleDaoLocal {

	@Override
	public List<Article> findByQuery(ArticleSearchQuery query) {
		String queryString = "SELECT a FROM Article a";
		List<String> conditions = new ArrayList<String>();
		if (query.getCode() != null && query.getCode().length() > 0) {
			conditions.add("a.code LIKE %" + query.getCode() + "%");
		}
		if (query.getName() != null && query.getName().length() > 0) {
			conditions.add("a.name LIKE %" + query.getName() + "%");
		}
		if (query.getCategories().size() > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append("(");
			for (int i = 0; i < query.getCategories().size(); i++) {
				if (i > 0) {
					builder.append(" OR ");
				}
				ArticleCategory cat = query.getCategories().get(i);
				builder.append("( a.articleCategory.id = " + cat.getId() + ")");
			}
			builder.append(")");
			conditions.add(builder.toString());
		}
		if (query.getPriceMin() > 0) {
			conditions.add("a.price >= " + query.getPriceMin());
		}
		if (query.getPriceMax() > 0) {
			conditions.add("a.price <= " + query.getPriceMax());
		}
		conditions.add("a.status = 'ACTIVE'");
		
		if (conditions.size() > 0) {
			StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append(queryString);
			queryBuilder.append(" WHERE ");
			for (int i = 0; i < conditions.size(); i++) {
				String condition = conditions.get(i);
				if (i > 0) {
					queryBuilder.append(" AND ");
				}
				queryBuilder.append("(" + condition + ")");
			}
			queryString = queryBuilder.toString();
		}
		
		return findBy(queryString);
	}
}
