package com.dzf.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dzf.entity.User;
import com.dzf.service.IUserService;
import com.dzf.utils.AlgorithmUtil;
import com.dzf.vo.ResultInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserServlet {
	private static final Logger log = LoggerFactory.getLogger(UserServlet.class);
	
	@Autowired
	private IUserService iUserService;
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResultInfo login(HttpServletRequest request,HttpServletResponse response){
		String ctx = request.getContextPath();
		ResultInfo result = new ResultInfo();
		String url = null;
		Boolean rememberMe = false;
		String remember = request.getParameter("rememberMe");
		if("ok".equals(remember)){
			rememberMe = true;
		}
		String login_name = request.getParameter("login_name");
		String password = request.getParameter("password");
		log.info("前台提交的数据：login_name:{},password:{},rememberMe:{}",login_name,password,remember);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(login_name,password);
		token.setRememberMe(rememberMe);
		try{
			subject.login(token);
			SavedRequest savedRequest = WebUtils.getSavedRequest(request);
			if(savedRequest!=null){
				url = savedRequest.getRequestUrl();//获取之前没登录之前的url
			}
			String retUrl = request.getHeader("Referer");  
			//request获取url
			log.info("servlet获取上一次请求的url:{}",retUrl); //这种方法不太适用，需要过滤掉一些网址
			log.info("上一次请求的url:{}",url);
			if(url==null){
				url  = ctx+"/user/main";
			}
		}catch (DisabledAccountException e) {
			e.printStackTrace();
			log.debug(e.toString());
			result.setCode("400");
			result.setDesc("账号已经被禁用！");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			log.debug(e.toString());
			result.setCode("300");
			result.setDesc("用户名或者密码错误");
		}
		result.setCode("666");
		result.setUrl(url);
		return result;
	}
	
	/**
	 * 用户登出 
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		String userName = ((User)subject.getPrincipal()).getLogin_name();
		subject.logout();
		log.info("用户{}退出了秦红霞养猪网系统",userName);
		return "login";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public ResultInfo register(HttpServletRequest request,User user){
		String ctx = request.getContextPath();
		log.info("注册封装的user：{}",user.toString());
		String password = user.getPassword();
		ResultInfo info = new ResultInfo();
		List<User> list = iUserService.selectList(new EntityWrapper<User>().eq("name", user.getName()));
		if(list!=null && list.size()>1){
			info.setCode("400");
			info.setDesc("用户名已经存在");
			return info;
		}
		//首先对密码进行加密
		String pass = AlgorithmUtil.alogrithm(user.getPassword(), user.getSalt());
		log.info("加密后的密码为：{}",pass);
		user.setPassword(pass);
		Date date = new Date();
		user.setCreate_time(date);
		iUserService.insert(user);
		log.info("用户注册成功");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getLogin_name(), password);
		subject.login(token);
		info.setDesc("恭喜您注册成功，3秒后自动跳转到主页！");
		info.setCode("666");
		info.setUrl(ctx+"/user/main");//直接跳转到主页
		return info;
	}
	/**
	 * 跳转到主页
	 * @return
	 */
	@RequestMapping("/main")
	public String  toIndex(){
		return "index";
	}
	/**
	 * 跳转到登录主页
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
}
