package model.articles;

import java.util.Date;

public class Article {
	private int id; // unique
	private String name;
	private ArticleCategory articleCategory;
	private double price; // unsigned
	private int inStock; // unsigned, if it becomes lower than minInStock inform seller
	private Date creationDate;
	private boolean neededInStock;
	private ArticleStatus status;
	private int minInStock; // unsigned

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

	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}

	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isNeededInStock() {
		return neededInStock;
	}

	public void setNeededInStock(boolean neededInStock) {
		this.neededInStock = neededInStock;
	}

	public ArticleStatus getStatus() {
		return status;
	}

	public void setStatus(ArticleStatus status) {
		this.status = status;
	}

	public int getMinInStock() {
		return minInStock;
	}

	public void setMinInStock(int minInStock) {
		this.minInStock = minInStock;
	}

}
