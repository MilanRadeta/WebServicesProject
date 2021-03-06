package model.payment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import model.articles.Article;
import model.payment.discounts.ItemDiscount;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable {
	private static final long serialVersionUID = 1569257937604437006L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JsonIgnore
	private Bill bill;
	@Column(nullable=false)
	private int itemNumber; // unique in bill
	@ManyToOne(fetch=FetchType.EAGER)
	private Article article;
	@Column(nullable=false)
	private double unitPrice; // on that day
	@Column(nullable=false)
	private double units;
	@Column(nullable=false)
	private double originalTotalPrice;
	@Column(nullable=false)
	private double discountPercentage;
	@Column(nullable=false)
	private double totalPrice; // with all discounts
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<ItemDiscount> discounts = new ArrayList<ItemDiscount>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

	public double getOriginalTotalPrice() {
		return originalTotalPrice;
	}

	public void setOriginalTotalPrice(double originalTotalPrice) {
		this.originalTotalPrice = originalTotalPrice;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ItemDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<ItemDiscount> discounts) {
		this.discounts = discounts;
	}

}
