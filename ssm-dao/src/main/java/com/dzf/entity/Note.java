package com.dzf.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("all")
public class Note implements Serializable{

	private Integer noteId;
	private String descrition;
	private String title;
	private Author author;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	public String getDescrition() {
		return descrition;
	}
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", descrition=" + descrition + ", title=" + title + ", author=" + author
				+ "]";
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
