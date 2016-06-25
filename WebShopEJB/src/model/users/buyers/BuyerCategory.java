package model.users.buyers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class BuyerCategory implements Serializable {
	private static final long serialVersionUID = -6975330980242658550L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; // unique
	private String name;
	@OneToMany
	private List<PaymentPointsBonus> paymentPointsBonuses = new ArrayList<PaymentPointsBonus>();

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
