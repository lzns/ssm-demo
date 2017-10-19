package com.dzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
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

	////////////////使用注解将上面的功能实现一遍//////////////////////////////
	/**
	 * 这个例子演示了怎么使用results
	 * @param name
	 * @param age
	 * @return
	 */
	@Results(id="indexResult",value={
			@Result(column="id",property="id",id= true),
			@Result(property="name",column="name"),
			@Result(column="age",property="age"),
			@Result(column="state",property="state")
	})
	@Select("select * from ssmTest t where t.name like concat('%',#{name},'%') and age > #{age}")
	public List<Index> getList2(@Param(value="name")String name,@Param(value="age")Integer age);
	
	
	/**
	 * 这个例子演示了如何使用注解返回插入数据的主键！记住这个返回的只是影响的条数，获取主键通过原来对象的id来获取即可
	 * @param index
	 * @return
	 */
	@Insert("insert into ssmTest(name,age,state) values(#{name},#{age},#{state})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public Integer getPkByInsert2(Index index);
	
	/**
	 * 这个例子演示的是通过xml映射文件获取主键，获取主键也是通过原来对象的getId（）来获取的
	 * @param author
	 * @return
	 */
	public Integer insertAuthor(Author author); 
	
	/**
	 * 这个例子是示例怎么使用@selectProvider这个注解的
	 * @param name
	 * @return
	 */
	@SelectProvider(type=com.dzf.entity.NoteResultSql.class,method="getNoteSql")
	public List<Note> getNotes(String name);
	
}


