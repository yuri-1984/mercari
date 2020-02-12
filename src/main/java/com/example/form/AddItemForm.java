package com.example.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 追加する商品情報を受け取るフォームクラス.
 * 
 * @author hiraokayuri
 */
public class AddItemForm {

	/** 商品ID */
	private String id;
	/** 名前 */
	@NotEmpty(message = "*error:may not be empty")
	@Size(min = 2, max = 100)
	private String name;
	/** 金額 */
	@NotEmpty(message = "*error:may not be empty")
	private String price;
	/** ブランド名 */
	@NotEmpty(message = "*error:may not be empty")
	@Size(min = 2, max = 40)
	private String brandName;
	/** カテゴリID */
	@NotNull(message = "*error:may not be empty")
	private Integer categoryId;
	/** コンディションID　*/
	@NotNull(message = "*error:may not be empty")
	private Integer itemConditionId;
	/** 商品説明 */
	@NotEmpty(message = "*error:may not be empty")
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
		return "AddItemForm [id=" + id + ", name=" + name + ", price=" + price + ", brandName=" + brandName
				+ ", categoryId=" + categoryId + ", itemConditionId=" + itemConditionId + ", itemDescription="
				+ itemDescription + "]";
	}

}
