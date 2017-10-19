package com.dzf.entity;

import java.io.Serializable;

public class Note implements Serializable{

	private Integer noteId;
	private String descrition;
	private String title;
	private Author author;
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
