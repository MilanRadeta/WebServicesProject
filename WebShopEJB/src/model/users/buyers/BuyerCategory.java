package model.users.buyers;

import java.util.List;

public class BuyerCategory {
	private int id; //unique
	private String name;
	private List<PaymentPointsBonus> paymentPointsBonuses;

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

	public List<PaymentPointsBonus> getPaymentPointsBonuses() {
		return paymentPointsBonuses;
	}

	public void setPaymentPointsBonuses(
			List<PaymentPointsBonus> paymentPointsBonuses) {
		this.paymentPointsBonuses = paymentPointsBonuses;
	}

}
