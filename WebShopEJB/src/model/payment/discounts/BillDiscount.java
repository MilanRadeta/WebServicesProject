package model.payment.discounts;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import model.payment.Bill;

@Entity
public class BillDiscount implements Serializable {
	private static final long serialVersionUID = -2315126859815709736L;
	
	@Id
	@GeneratedValue
	private int id; //unique
	@ManyToOne
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
