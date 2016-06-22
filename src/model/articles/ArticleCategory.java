package model.articles;

public class ArticleCategory {

	private int id; //unique
	private ArticleCategory parentCategory;
	private String name;
	private double maxDiscount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArticleCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(ArticleCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

}
