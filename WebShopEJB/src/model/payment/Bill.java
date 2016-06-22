package model.payment;

import java.util.Date;
import java.util.List;

import model.payment.discounts.BillDiscount;
import model.users.Buyer;

public class Bill {
	private int id; // unique
	private Date date;
	private Buyer buyer;
	private BillState state;
	private double originalTotalPrice;
	private double discountPercentage;
	private double totalPrice; // with all the discounts
	private int spentPoints;
	private int receivedPoints;
	private List<BillDiscount> discounts;
	private List<Item> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public BillState getState() {
		return state;
	}

	public void setState(BillState state) {
		this.state = state;
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

	public int getSpentPoints() {
		return spentPoints;
	}

	public void setSpentPoints(int spentPoints) {
		this.spentPoints = spentPoints;
	}

	public int getReceivedPoints() {
		return receivedPoints;
	}

	public void setReceivedPoints(int receivedPoints) {
		this.receivedPoints = receivedPoints;
	}

	public List<BillDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<BillDiscount> discounts) {
		this.discounts = discounts;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
