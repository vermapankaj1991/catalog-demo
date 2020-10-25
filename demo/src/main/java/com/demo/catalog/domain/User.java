package com.demo.catalog.domain;

public class User {
	private Integer userId;
	
	private String userName;
	

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @param userId
	 * @param userName
	 * @param isNew
	 */
	public User(Integer userId, String userName ) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}
	
	
}
