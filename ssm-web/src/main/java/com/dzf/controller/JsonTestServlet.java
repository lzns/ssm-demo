package com.dzf.controller;

import com.alibaba.fastjson.JSONObject;
import com.dzf.vo.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 
 * @author dingzf
 * @date 2018年1月20日
 * @time 11:25:25
 */
@Controller
@RequestMapping("/json")
public class JsonTestServlet {

	/**
	 * 测试返回json类型的数据，
	 * 返回到前台是一个json对象
	 * 此时消息转换器走的是json消息转换器
	 */
	@RequestMapping("/test1")
	@ResponseBody
	public Object test1(HttpServletResponse response){
		ResultInfo result = new ResultInfo();
		result.setCode("200");
		result.setDesc("请求成功！");
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "求成");
		map.put("age","35");
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("name","liqiucheng");
		map2.put("age","12");
		map2.put("sex","M");
		List list = new ArrayList();
		list.add(map);
		list.add(map2);
		//result.setData(map);
		//return result;
		return list;
	}
	/**
	 * 测试返回json类型的数据，
	 * 返回到前台是个字符类型的json串	
	 * 此时走的是string消息转换器
	 */
	@RequestMapping(value="/test2"/*,produces="text/html;charset=UTF-8"*/)
	@ResponseBody
	public String test2(HttpServletResponse response){
		ResultInfo result = new ResultInfo();
		result.setCode("200");
		result.setDesc("请求成功！");
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "红霞");
		map.put("age","22");
		result.setData(map);
		String str = JSONObject.toJSONString(result);
		System.out.println(str);
		return str;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/test4")
	@ResponseBody
	public String test4(HttpServletRequest request,HttpServletResponse response){
		ResultInfo result = new ResultInfo();
		String name = request.getParameter("name");	
		System.out.println(name);
		System.out.println("从前台拿到的："+name);
		result.setDesc(name);
		String str = JSONObject.toJSONString(result);
		return str;
	}
	
	@RequestMapping("/test5")
	public String test5(ResultInfo result){
		Date birthday = result.getBirthday();
		System.out.println(birthday);
		System.out.println(result);
		return "success";
	}
	
	/**
	 * 测试自定义消息转换器
	 * 在请求头上必须加上produces="application/x-result;charset=utf-8"
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/test6",produces="application/x-result;charset=utf-8")
	@ResponseBody
	public ResultInfo test6(HttpServletRequest request,HttpServletResponse response){
		ResultInfo result = new ResultInfo();
		result.setCode("200");
		result.setDesc("请求成功！");
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "红霞");
		map.put("age","22");
		result.setData(map);
		return result;
	}
}
