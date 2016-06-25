package model.users.buyers;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class PaymentPointsBonus implements Serializable {
	private static final long serialVersionUID = -4591451095977557720L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private double min;
	private double max;
	private double percent;
	@ManyToOne
	private BuyerCategory buyerCategory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public BuyerCategory getBuyerCategory() {
		return buyerCategory;
	}

	public void setBuyerCategory(BuyerCategory buyerCategory) {
		this.buyerCategory = buyerCategory;
	}

}
