package model.payment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import model.payment.discounts.BillDiscount;
import model.users.Buyer;

@Entity
public class Bill implements Serializable {
	private static final long serialVersionUID = -5381510478428079568L;
	
	@Id
	@GeneratedValue
	private int id; // unique
	private Date date;
	@ManyToOne
	private Buyer buyer;
	private BillState state;
	private double originalTotalPrice;
	private double discountPercentage;
	private double totalPrice; // with all the discounts - spent points
	private int spentPoints;
	private int receivedPoints;
	@OneToMany
	private List<BillDiscount> discounts = new ArrayList<BillDiscount>();
	@OneToMany
	private List<Item> items = new ArrayList<>();

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
