package com.demo.catalog.domain;

import java.util.List;

public class PurchaseSummary {
	private List<Product> product;
	private TotalInfo total;
	/**
	 * @param product
	 * @param discount
	 */
	public PurchaseSummary(List<Product> product, TotalInfo total) {
		super();
		this.product = product;
		this.total = total;
	}
	/**
	 * 
	 */
	public PurchaseSummary() {
		super();
	}
	/**
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	/**
	 * @return the discount
	 */
	public TotalInfo getTotal() {
		return total;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setTotal(TotalInfo total) {
		this.total = total;
	}
	

}
