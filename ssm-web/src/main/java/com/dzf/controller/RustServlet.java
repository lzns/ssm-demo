package com.dzf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/rust")
public class RustServlet {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/get")
	@ResponseBody
	public String get(@RequestParam(name="name",required=false,defaultValue="ding")String name){
//		String str = restTemplate.postForObject("http://localhost:8081/restDemo/rest", name,String.class);
		System.out.println("========"+name+"==========");
		Map map = new HashMap();
		map.put("name", name);
		String str = restTemplate.getForObject("http://localhost:8081/restDemo/rest?name="+name,String.class);
		System.out.println(str);
		return str;
	}
}
