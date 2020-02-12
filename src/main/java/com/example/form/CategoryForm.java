package com.example.form;

/**
 * list.htmlでカテゴリー要素を受け取りjson形式で返すためのformクラス.
 * 
 * @author hiraokayuri
 */
public class CategoryForm {
	/** 親カテゴリ　*/
	private String parentcategory;
	/** 子カテゴリ */
	private String childcategory2;
	/** 孫カテゴリ　*/
	private String grandchildcategory3;
	public String getParentcategory() {
		return parentcategory;
	}
	public void setParentcategory(String parentcategory) {
		this.parentcategory = parentcategory;
	}
	public String getChildcategory2() {
		return childcategory2;
	}
	public void setChildcategory2(String childcategory2) {
		this.childcategory2 = childcategory2;
	}
	public String getGrandchildcategory3() {
		return grandchildcategory3;
	}
	public void setGrandchildcategory3(String grandchildcategory3) {
		this.grandchildcategory3 = grandchildcategory3;
	}
	@Override
	public String toString() {
		return "CategoryForm [parentcategory=" + parentcategory + ", childcategory2=" + childcategory2
				+ ", grandchildcategory3=" + grandchildcategory3 + "]";
	}


}
