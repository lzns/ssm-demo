package com.dzf.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzf.entity.Author;
import com.dzf.entity.Index;
import com.dzf.entity.Note;
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
	
	@RequestMapping("getList")
	@ResponseBody
	public List<Index> getList(String name,Integer age){
		System.out.println("-------------"+name);
		List<Index> list = indexService.getList(name,age);
		return list;
	}
	
	@RequestMapping("/getPkByInsert")
	public String getPkByInsert(String name,String state,Integer age,Model model){
		Long pk = indexService.getPkByInsert(name, state, age);
		String msg = null;
		if(pk>0){
			msg = "插入成功，这条数据的主键是"+pk;
		}else{
			msg = "数据插入失败！！";
		}
//		model.addAttribute("hello",msg);
//		return "index";
		return msg;
	}

	@RequestMapping("queryForPage")
	@ResponseBody
	public Map queryForpage(Integer[] ids){
		System.out.println(ids);
		return indexService.queryForPage(ids);
	}
	
	@RequestMapping("queryNote")
	@ResponseBody
	public List<Note> queryNote(){
		return indexService.queryNoteAndAuthor();
	}
	@RequestMapping("queryAuthor")
	@ResponseBody
	public Author queryAuthor(Integer id){
		System.out.println(id);
		return indexService.queryAuthorAndNotes(id);
	}
	
	/**
	 * 获取主键通过插入的数据
	 */
	@RequestMapping("/getPkByList2")
	@ResponseBody
	public Integer getPkByList2 (Index index,HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println(index);
		return indexService.getPkByInsert2(index);
	}

	@RequestMapping("/insertAuthor")
	@ResponseBody
	public Integer insertAuthor(Author author){
		System.out.println(author.toString());
		return indexService.insertAuthor(author);
	}
	
	@RequestMapping("getNotes")
	@ResponseBody
	public Map<String,Object> getNotes(String name){
		System.out.println("--------"+name);
		return indexService.getNotes(name);
	}
	
}
