package model.payment;

import java.util.ArrayList;
import java.util.List;

import model.articles.Article;
import model.payment.discounts.ItemDiscount;

public class Item {
	private Bill bill;
	private int itemNumber; //unique in bill
	private Article article;
	private double unitPrice; //on that day
	private double units;
	private double originalTotalPrice;
	private double discountPercentage;
	private double totalPrice; //with all discounts
	private List<ItemDiscount> discounts = new ArrayList<ItemDiscount>();
	
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
