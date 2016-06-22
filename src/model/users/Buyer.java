package model.users;

import java.util.List;

import model.Payment;
import model.users.buyers.BuyerCategory;

public class Buyer extends User {

	private String address;
	private double points;
	private BuyerCategory category;
	private List<Payment> paymentHistory;

	public Buyer() {
		setRole(Role.BUYER);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BuyerCategory getCategory() {
		return category;
	}

	public void setCategory(BuyerCategory category) {
		this.category = category;
	}

	public List<Payment> getPaymentHistory() {
		return paymentHistory;
	}

	public void setPaymentHistory(List<Payment> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

}
