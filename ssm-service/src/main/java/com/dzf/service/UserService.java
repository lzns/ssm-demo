package com.dzf.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dzf.dao.UserDao;
import com.dzf.entity.User;

/**
 * <p>用户服务层 </p>
 * @author dingzf
 * @date 2017年12月25日
 * @time 21:02:28
 */
@Service
public class UserService {

	@Resource 
	private UserDao userDao;

	/**
	 * 通过用户名查找用户
	 * @param name
	 * @return
	 */
	public User getUserByName (String name){
		if(name == null){
			return null;
		}
		return userDao.getUserByName(name);
	}
	
	public Integer addUser(User user ){
		if(user == null){
			return 0;
		}
		return userDao.addUser(user);
	}
}
