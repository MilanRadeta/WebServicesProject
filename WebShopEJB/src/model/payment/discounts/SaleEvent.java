package model.payment.discounts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.articles.ArticleCategory;

@Entity
@Table
public class SaleEvent implements Serializable {
	private static final long serialVersionUID = -2064753681681715061L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; //unique
	private String name;
	@Temporal(TemporalType.TIME)
	private Date actionFrom;
	@Temporal(TemporalType.TIME)
	private Date actionTo;
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
	
	public Date getActionFrom() {
		return actionFrom;
	}
	public void setActionFrom(Date actionFrom) {
		this.actionFrom = actionFrom;
	}
	public Date getActionTo() {
		return actionTo;
	}
	public void setActionTo(Date actionTo) {
		this.actionTo = actionTo;
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
