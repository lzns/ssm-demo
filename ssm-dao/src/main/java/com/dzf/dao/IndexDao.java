package com.dzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dzf.entity.Author;
import com.dzf.entity.Index;
import com.dzf.entity.Note;


@Repository
public interface IndexDao {

	public Index queryByName(String str);

	public Integer insert(Index index);
	
	/**
	 * 使用param的作用是因为超过两个参数的时候，mybatis识别不了，所以需要加上@Param
	 * @param name
	 * @param age
	 * @return
	 */
	public List<Index> getList(@Param(value="name")String name,@Param(value="age")Integer age);
	
	public Long getPkByInsert(@Param(value="name") String name,@Param(value="state") String state,@Param(value="age")Integer age);
	
	public  List<Index> queryForPage(Integer [] ids);
	
	public List<Note> queryNoteAndAuthor();
	
	public Author queryAuthorAndNotes(@Param(value="id")Integer id);
	
}
