package com.dzf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzf.service.RedisService;

@Controller
@RequestMapping("redis")
public class RedisTest {
	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/setKey")
	public void setKey(String key,String value){
		key="name";
		value="秦红霞";
		redisService.setKey(key, value);
	}

	@RequestMapping("/setKedExpired")
	public void setKey(String key,String value,@RequestParam(name="time",defaultValue="0")long time){
		key="pol";
		value="1212121233";
		time=20l;
		redisService.setKedExpired(key, value,time);
	}
	
	@RequestMapping("/getKey")
	@ResponseBody
	public String getKey(HttpServletResponse response,HttpServletRequest request,String key){
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		request.getParameter("");
		return redisService.getKey(key);
	}
	
}
