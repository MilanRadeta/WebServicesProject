package model.payment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.payment.discounts.BillDiscount;
import model.users.Buyer;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "findOrderedBills", query = "SELECT b FROM Bill b WHERE b.state = 'ORDERED'"),
		@NamedQuery(name = "findByBuyer", query = "SELECT b FROM Bill b WHERE b.buyer.id = :id") })
public class Bill implements Serializable {
	private static final long serialVersionUID = -5381510478428079568L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // unique
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER)
	private Buyer buyer;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BillState state;
	@Column(nullable = false)
	private double originalTotalPrice;
	@Column(nullable = false)
	private double discountPercentage;
	@Column(nullable = false)
	private double totalPrice; // with all the discounts - spent points
	@Column(nullable = false)
	private int spentPoints;
	@Column(nullable = false)
	private int receivedPoints;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<BillDiscount> discounts = new ArrayList<BillDiscount>();
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
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
