package com.example.domain;

/**
 * itemsテーブルのエンティティクラス.
 * 
 * @author hiraokayuri
 *
 */
public class Item {
	/** ID */
	private Integer id;
	/** 商品名 */
	private String name;
	/** コンディションID */
	private Integer itemConditionId;
	/** カテゴリーID */
	private Integer categoryId;
	/** ブランド名 */
	private String brandName;
	/** 金額 */
	private double price;
	/** 運送 */
	private String shipping;
	/** 商品詳細 */
	private String itemDescription;
	/** カテゴリー */
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getItemConditionId() {
		return itemConditionId;
	}

	public void setItemConditionId(Integer itemConditionId) {
		this.itemConditionId = itemConditionId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", itemConditionId=" + itemConditionId + ", categoryId="
				+ categoryId + ", brandName=" + brandName + ", price=" + price + ", shipping=" + shipping
				+ ", itemDescription=" + itemDescription + ", category=" + category + "]";
	}

}