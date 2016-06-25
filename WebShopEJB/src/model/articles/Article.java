package model.articles;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Article implements Serializable {
	private static final long serialVersionUID = -7264390151265136042L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; // unique
	private String name;
	@ManyToOne
	private ArticleCategory articleCategory;
	private double price; // unsigned
	private double inStock; // unsigned, if it becomes lower than minInStock inform seller
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	private boolean neededInStock;
	private ArticleStatus status;
	private double minInStock; // unsigned

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

	public double getInStock() {
		return inStock;
	}

	public void setInStock(double inStock) {
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

	public double getMinInStock() {
		return minInStock;
	}

	public void setMinInStock(double minInStock) {
		this.minInStock = minInStock;
	}

}
