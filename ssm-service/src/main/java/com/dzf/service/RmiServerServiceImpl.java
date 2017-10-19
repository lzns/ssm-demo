package com.dzf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzf.dao.AuthorDao;
import com.dzf.entity.Author;
//@Service   //这里面不需要自动注入，需要手写bean
public class RmiServerServiceImpl implements RmiServerService {
	
	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public List<Author> getAuthorByName(String name) {
		// TODO Auto-generated method stub
		if(name==null && "".equals(name)){
			return null;
		}
		return authorDao.getAuthorByName(name);
	}

	@Transactional
	@Override
	public Integer insertAuthor(Author author) {
		// TODO Auto-generated method stub
		if(author == null){
			return null;
		}
		authorDao.insert(author);
		return author.getId(); //返回的插入这条数据的主键值
	}

}
