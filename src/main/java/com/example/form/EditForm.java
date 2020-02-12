package com.example.form;

import java.util.List;

/**
 * edit.html変更した商品情報を受け取るフォームクラス.
 * 
 * @author hiraokayuri
 */
public class EditForm {
	/** 商品ID */
	private String id;
	/** 名前 */
	private String name;
	/** 金額 */
	private String price;
	/** ブランド名 */
	private String brandName;
	/** カテゴリID */
	private Integer categoryId;
	/** 親カテゴリID */
	private List<Integer> parentId;
	/**　コンディションID */
	private Integer itemConditionId;
	/** 商品説明 */
	private String itemDescription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public List<Integer> getParentId() {
		return parentId;
	}

	public void setParentId(List<Integer> parentId) {
		this.parentId = parentId;
	}

	public Integer getItemConditionId() {
		return itemConditionId;
	}

	public void setItemConditionId(Integer itemConditionId) {
		this.itemConditionId = itemConditionId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "EditForm [id=" + id + ", name=" + name + ", price=" + price + ", brandName=" + brandName
				+ ", categoryId=" + categoryId + ", parentId=" + parentId + ", itemConditionId=" + itemConditionId
				+ ", itemDescription=" + itemDescription + "]";
	}

}