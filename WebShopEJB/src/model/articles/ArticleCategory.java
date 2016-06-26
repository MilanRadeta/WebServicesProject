package model.articles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ArticleCategory implements Serializable {
	private static final long serialVersionUID = -8564156799552453357L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; //unique
	@Column(unique=true, nullable=false)
	private String code;
	private boolean consumerArticle;
	private String name;
	private double maxDiscount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isConsumerArticle() {
		return consumerArticle;
	}

	public void setConsumerArticle(boolean consumerArticle) {
		this.consumerArticle = consumerArticle;
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
