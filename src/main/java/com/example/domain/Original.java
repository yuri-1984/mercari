package com.example.domain;

/**
 * originalテーブルのエンティティクラス.
 * 
 * @author hiraokayuri
 *
 */
public class Original {
	/** ID */
	private Integer id;
	/** コンディションID */
	private Integer conditionId;
	/** カテゴリー名 */
	private String categoryName;
	/** ブランド名 */
	private String brandName;
	/** 料金 */
	private Integer price;
	/** 運送 */
	private String shipping;
	/** 商品詳細 */
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Original [id=" + id + ", conditionId=" + conditionId + ", categoryName=" + categoryName + ", brandName="
				+ brandName + ", price=" + price + ", shipping=" + shipping + ", description=" + description + "]";
	}

}