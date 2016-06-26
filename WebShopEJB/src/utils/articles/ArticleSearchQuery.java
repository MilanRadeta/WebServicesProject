package utils.articles;

import java.util.ArrayList;
import java.util.List;

import model.articles.ArticleCategory;
import model.articles.ArticleStatus;

public class ArticleSearchQuery {

	private String code;
	private String name;
	private List<ArticleCategory> categories = new ArrayList<ArticleCategory>();
	private double priceMin = -1;
	private double priceMax = -1;
	private ArticleStatus status = ArticleStatus.ACTIVE;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ArticleCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ArticleCategory> categories) {
		this.categories = categories;
	}

	public double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}

	public double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}

	public ArticleStatus getStatus() {
		return status;
	}

	public void setStatus(ArticleStatus status) {
		this.status = status;
	}

	
	
}
