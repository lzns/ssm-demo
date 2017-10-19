package com.dzf.entity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 这个类是用来演示insertProvider 注解的
 * @author adminstrtor
 *
 */
public class NoteResultSql{
	
	// not user @param  可以传入多个参数
	public String getNoteSql(final String title){
		return new SQL(){
			{
				SELECT("*");
				FROM("note");
				if(title!=null){
					WHERE(" title like concat('%',#{title},'%')");
				}
			}
		}.toString();
	}
	// not user @param  只可以传入一个参数
	public String getNoteSql2(@Param(value="title")final String title){
		return new SQL(){
			{
				SELECT("*");
				FROM("note");
				if(title!=null){
					WHERE(" title like concat('%',#{title},'%')");
				}
			}
		}.toString();
	}
}
