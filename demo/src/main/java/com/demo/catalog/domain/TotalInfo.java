package com.demo.catalog.domain;

public class TotalInfo {
	private Double discountRate;
	private Double discount;
	private Double totalAmountBeforeDiscount;
	private Double totalAmountAfterDiscount;
	
	
	/**
	 * 
	 */
	public TotalInfo() {
		super();
	}
	/**
	 * @param discountRate
	 * @param discount
	 * @param totalAmountBeforeDiscont
	 * @param totalAmountAfterDiscont
	 */
	public TotalInfo(Double discountRate, Double discount, Double totalAmountBeforeDiscount, Double totalAmountAfterDiscount) {
		super();
		this.discountRate = discountRate;
		this.discount = discount;
		this.totalAmountBeforeDiscount = totalAmountBeforeDiscount;
		this.totalAmountAfterDiscount = totalAmountAfterDiscount;
	}
	/**
	 * @return the discountRate
	 */
	public Double getdiscountRate() {
		return discountRate;
	}
	/**
	 * @param discountRate the discountRate to set
	 */
	public void setdiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}
	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	/**
	 * @return the totalAmountBeforeDiscont
	 */
	public Double getTotalAmountBeforeDiscount() {
		return totalAmountBeforeDiscount;
	}
	/**
	 * @param totalAmountBeforeDiscont the totalAmountBeforeDiscont to set
	 */
	public void setTotalAmountBeforeDiscount(Double totalAmountBeforeDiscount) {
		this.totalAmountBeforeDiscount = totalAmountBeforeDiscount;
	}
	/**
	 * @return the totalAmountAfterDiscont
	 */
	public Double getTotalAmountAfterDiscount() {
		return totalAmountAfterDiscount;
	}
	/**
	 * @param totalAmountAfterDiscont the totalAmountAfterDiscount to set
	 */
	public void setTotalAmountAfterDiscont(Double totalAmountAfterDiscount) {
		this.totalAmountAfterDiscount = totalAmountAfterDiscount;
	}
	
	
	
}
