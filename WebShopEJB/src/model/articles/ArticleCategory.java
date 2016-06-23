package model.articles;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ArticleCategory implements Serializable {
	private static final long serialVersionUID = -8564156799552453357L;
	
	@Id
	@GeneratedValue
	private int id; //unique
	@ManyToOne
	private ArticleCategory parentCategory;
	private String name;
	private double maxDiscount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArticleCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(ArticleCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

}
