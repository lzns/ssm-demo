package com.dzf.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.dzf.entity.User;

@Repository
public interface UserDao {
//	@Select("select * from user t where t.username = #{name}")
	User getUserByName(String name);
	int addUser(User user);
	int deleteUserById(Integer userId); 
}
