package com.demo.catalog.domain;

public class Product {

	private Integer productId;
	private String productName;
	private String productType;
	private Double cost;
	private Boolean isPromoApplicable;
	
		
	/**
	 * 
	 */
	public Product() {
		super();
	}
	/**
	 * @param productId
	 * @param productName
	 * @param productType
	 * @param cost
	 * @param isPromoApplicable
	 */
	public Product(Integer productId, String productName, String productType, Double cost, Boolean isPromoApplicable) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.cost = cost;
		this.isPromoApplicable = isPromoApplicable;
	}
	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}
	
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	/**
	 * @return the isPromoApplicable
	 */
	public Boolean getIsPromoApplicable() {
		return isPromoApplicable;
	}
	/**
	 * @param isPromoApplicable the isPromoApplicable to set
	 */
	public void setIsPromoApplicable(Boolean isPromoApplicable) {
		this.isPromoApplicable = isPromoApplicable;
	}
	
	
	
	
}
