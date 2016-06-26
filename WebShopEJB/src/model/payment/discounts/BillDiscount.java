package model.payment.discounts;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import model.payment.Bill;

@Entity
public class BillDiscount implements Serializable {
	private static final long serialVersionUID = -2315126859815709736L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // unique
	@ManyToOne(fetch=FetchType.EAGER)
	private Bill bill;
	@Column(nullable = false)
	private double discountPercentage;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
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
