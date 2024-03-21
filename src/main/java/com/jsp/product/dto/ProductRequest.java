package com.jsp.product.dto;

public class ProductRequest {
	private String productName;
	private String productcategory;
	private int productPrice;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	@Override
	public String toString() {
		return "ProductRequest [productName=" + productName + ", productcategory=" + productcategory + ", productPrice="
				+ productPrice + "]";
	}
	
	
	

}
