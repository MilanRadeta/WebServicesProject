package model.users.buyers;

public class PaymentPointsBonus {
	private double min;
	private double max;
	private double percent;
	private BuyerCategory buyerCategory;

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
