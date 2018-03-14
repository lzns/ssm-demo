package com.dzf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//@Service
public class RedisService {

	@Autowired
	private RedisTemplate<String, Object> template;
	
	/**
	 * 操作string 
	 */
	
	public void setKey(String key,String value){
		ValueOperations<String, Object> opsForValue = template.opsForValue();
		opsForValue.set(key, value);
	} 
	public void setKedExpired(String key,String value,long time){
		template.opsForValue().set(key, value, time, TimeUnit.SECONDS);//指定过期时间
	}
	public String getKey(String key){
//	    template.opsForValue().g
		return	(String)template.opsForValue().get(key);//如果过期了获取的是空
	    
	}
	public void setKeys(Map<String,Object> map){
		//设置多个值 
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("mutil1", "mutil111");
//		map.put("mutil2", "mutil222");
//		map.put("mutil3", "mutil333");
		template.opsForValue().multiSet(map); 
	}
	public List<Object> getKeys(List<String> list){
		List<Object> list2 = template.opsForValue().multiGet(list);
		System.out.println(list2);// {mutil111,mutil222,mutil333}
		return list2;
	}
}
