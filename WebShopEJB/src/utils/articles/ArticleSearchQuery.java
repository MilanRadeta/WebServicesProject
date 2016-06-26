package utils.articles;

import java.util.ArrayList;
import java.util.List;

import model.articles.ArticleCategory;

public class ArticleSearchQuery {

	private int id = -1;
	private String name;
	private List<ArticleCategory> categories = new ArrayList<ArticleCategory>();
	private double priceMin = -1;
	private double priceMax = -1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
