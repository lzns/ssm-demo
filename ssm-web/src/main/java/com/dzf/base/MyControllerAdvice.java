package com.dzf.base;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dingzf
 * @date 2018/3/19
 * @time 17:53
 */
@ControllerAdvice
public class MyControllerAdvice {
    @ModelAttribute("ctx3")
    public String getCtx(HttpServletRequest request, Model module){
        final String contextPath = request.getContextPath();
        module.addAttribute("ctx",contextPath);
        System.out.println("____________"+contextPath);
        System.out.println("========应用到所有注解了requestMapping注解方法，在其执行前返回把返回值放到model中");
        return contextPath;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        System.out.println("================应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e ,HttpServletRequest request){
        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出Exception异常时执行");
        return "error";
    }
}

