package model.payment.discounts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.articles.ArticleCategory;

@Entity
@Table
public class SaleEvent implements Serializable {
	private static final long serialVersionUID = -2064753681681715061L;
	
	@Id
	@GeneratedValue
	private int id; //unique
	private String name;
	private Date from;
	private Date to;
	private double discount;
	@OneToMany
	private List<ArticleCategory> categories;
	
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
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public List<ArticleCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<ArticleCategory> categories) {
		this.categories = categories;
	}
	
	
}
