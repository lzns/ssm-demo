package com.dzf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dzf.entity.Index;
import com.dzf.service.IndexService;

@Controller
@RequestMapping("/ssm")
public class IndexServlet {

	@Resource
	private IndexService indexService;
	
	@RequestMapping("/hello")
	public String hello(String str,Model model){
		Index helloService = indexService.helloService(str);
		model.addAttribute("hello",helloService);
		return "index";
	}
	
	
	@RequestMapping("/add")
	public String addPerson(Index index,Model model){
		System.out.println(index);
		Integer primary = indexService.adPerson(index);
		if(primary>0){
			model.addAttribute("hello","添加成功");
		}else{
			model.addAttribute("hello","添加失败");
		}
		return "index";
	}
	
	
}
