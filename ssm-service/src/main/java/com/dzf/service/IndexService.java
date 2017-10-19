package com.dzf.service;

import java.util.List;
import java.util.Map;

import com.dzf.entity.Author;
import com.dzf.entity.Index;
import com.dzf.entity.Note;

public interface IndexService {
	Index helloService(String str);
	Integer adPerson(Index index);
	List<Index> getList(String name, Integer age);
	Long getPkByInsert(String name,String state,Integer age);
	//分页查询
	Map queryForPage(Integer [] ids);
	
	List<Note> queryNoteAndAuthor();
	
	Author queryAuthorAndNotes(Integer id);
	
	Integer  getPkByInsert2(Index index);
	Integer insertAuthor(Author author);
	
	Map<String,Object> getNotes(String title);
}
