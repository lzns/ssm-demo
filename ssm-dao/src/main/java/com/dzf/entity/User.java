package com.dzf.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -1174777041433884148L;
	private Integer userId;
	private String name;
	private String password;
	public User() {
		super();
	}
	public User(Integer userId, String name, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", getUserId()=" + getUserId()
				+ ", getName()=" + getName() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
