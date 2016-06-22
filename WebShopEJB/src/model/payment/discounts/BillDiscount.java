package model.payment.discounts;

import model.payment.Bill;

public class BillDiscount {
	private int id; //unique
	private Bill bill;
	private double discountPercentage;
	private DiscountType type;
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
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public DiscountType getType() {
		return type;
	}
	public void setType(DiscountType type) {
		this.type = type;
	}
	
	
}
