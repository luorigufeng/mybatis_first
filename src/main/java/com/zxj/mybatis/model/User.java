package com.zxj.mybatis.model;

public class User {
	private int id;
	private String userName;
	private String userAge;
	private String userAddress;

	public int getId() {
		return id;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getUserAge() {
		return userAge;
	}

	public User setUserAge(String userAge) {
		this.userAge = userAge;
		return this;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public User setUserAddress(String userAddress) {
		this.userAddress = userAddress;
		return this;
	}
}
