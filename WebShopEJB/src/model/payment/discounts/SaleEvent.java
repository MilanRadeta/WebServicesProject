package model.payment.discounts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // unique
	@Column(unique = true)
	private String code;
	@Column(nullable = false)
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date actionFrom;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date actionTo;
	@Column(nullable = false)
	private double discount;
	@OneToMany(fetch=FetchType.EAGER)
	private List<ArticleCategory> categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

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
