package model.users.buyers;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table
@NamedQuery(name="findBonusByBuyerCategory", query="SELECT b FROM PaymentPointsBonus b "
												+ "WHERE b.buyerCategory.id = :id")
public class PaymentPointsBonus implements Serializable {
	private static final long serialVersionUID = -4591451095977557720L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private double min;
	private double max;
	private double percent;
	@ManyToOne
	@JsonIgnore
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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PaymentPointsBonus) {
			PaymentPointsBonus other = (PaymentPointsBonus) obj;
			return other.getId() == id;	
		}
		return false;
	}

	
	
}
