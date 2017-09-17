package com.dzf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzf.dao.IndexDao;
import com.dzf.entity.Index;

@Service
public class IndexServiceImpl implements IndexService {

	@Autowired
	private IndexDao indexDao;
	
	@Override
	public Index helloService(String str) {
		if(null == str && str.length()==0){
			return null;
		}
		return indexDao.queryByName(str);
	}

}
