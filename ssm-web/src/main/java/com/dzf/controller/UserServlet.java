package com.dzf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzf.service.UserService;

@Controller
@RequestMapping("/user")
public class UserServlet {

	@Resource
	private UserService userService;
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(){
		
		
		return "main";
	}
	
	/**
	 * 用户登出 
	 */
	@RequestMapping("logout")
	public String logout(){
		
		return "login";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/register")
	public String register(){
		
		
		return "register";
	}
	
	
}
