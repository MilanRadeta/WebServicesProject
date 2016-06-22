package utils.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import model.articles.Article;

public class ShoppingCart {
	private Map<Article, Integer> items = new HashMap<>();

	public Map<Article, Integer> getItems() {
		return items;
	}

	public void setItems(Map<Article, Integer> items) {
		this.items = items;
	}

}
