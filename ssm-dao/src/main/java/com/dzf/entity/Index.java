package com.dzf.entity;

public class Index {

	private Integer id;
	private String name;
	private String state;
	private Integer age;
	
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStr() {
		return state;
	}

	public void setStr(String str) {
		this.state = str;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Index [id=" + id + ", name=" + name + ", str=" + state + ", age=" + age + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
