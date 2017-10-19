package com.dzf.service;

import java.util.List;

import com.dzf.entity.Author;

public interface RmiServerService {
	public List<Author> getAuthorByName(String name);
	
	public Integer insertAuthor(Author author);
}
