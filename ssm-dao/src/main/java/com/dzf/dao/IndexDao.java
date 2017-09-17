package com.dzf.dao;

import org.springframework.stereotype.Repository;

import com.dzf.entity.Index;


@Repository
public interface IndexDao {

	public Index queryByName(String str);

}
