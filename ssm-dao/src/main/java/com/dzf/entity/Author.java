package com.dzf.entity;

import java.util.List;

public class Author {
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", tel=" + tel + ", age=" + age + ", noteList=" + noteList + "]";
	}
	private Integer id;
	private String name;
	private String tel;
	private Integer age;
	private List<Note> noteList;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<Note> getNoteList() {
		return noteList;
	}
	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}
}
