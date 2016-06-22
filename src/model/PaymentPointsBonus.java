package model;

public class PaymentPointsBonus {
	private double min;
	private double max;
	private BuyerCategory buyerCategory;
	private double percent;
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
	public BuyerCategory getBuyerCategory() {
		return buyerCategory;
	}
	public void setBuyerCategory(BuyerCategory buyerCategory) {
		this.buyerCategory = buyerCategory;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	
}
