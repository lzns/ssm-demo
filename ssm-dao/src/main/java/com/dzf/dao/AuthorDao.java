package com.dzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.dzf.entity.Author;

@Repository
public interface AuthorDao {

	@Select("select * from author t where t.id = #{id}")
	public Author getAuthorById(Integer Id);
	
	@Select("select * from author t where t.name like concat('%',#{name},'%')")
	public List<Author> getAuthorByName(String name);
	
	@Insert("insert into author(name,age,tel) values (#{name},#{age},#{tel})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public Integer insert(Author author);
}
