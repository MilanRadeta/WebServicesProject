package model.users;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import model.payment.Bill;
import model.users.buyers.BuyerCategory;

@Entity
@DiscriminatorValue(value=Role.Values.BUYER)
public class Buyer extends User {
	private static final long serialVersionUID = 1539437921876611128L;
	
	// Buyer profile
	private String address;
	private double points;
	@ManyToOne(fetch=FetchType.EAGER)
	private BuyerCategory category;
	@OneToMany(fetch=FetchType.EAGER)
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
