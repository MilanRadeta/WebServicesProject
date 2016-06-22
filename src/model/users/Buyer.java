package model.users;

import java.util.List;

import model.payment.Bill;
import model.users.buyers.BuyerCategory;

public class Buyer extends User {

	// Buyer profile
	private String address;
	private double points;
	private BuyerCategory category;
	private List<Bill> paymentHistory;

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

	public List<Bill> getPaymentHistory() {
		return paymentHistory;
	}

	public void setPaymentHistory(List<Bill> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

}
