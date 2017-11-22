package com.dzf.controller;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 文件上传测试
 * @author dingzf 
 * @date 2017年11月19日
 * @time 21:29:24
 */
@Controller
@RequestMapping("load")
@MultipartConfig
public class MyFileUpload {

	private static Logger log = LoggerFactory.getLogger(MyFileUpload.class);
	/**
	 * common FileUpload jar 包里提供的 适用servlet 3.0 以下的文件上传
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload1")
	@ResponseBody
	private String upload1(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("aplication/json;charset=utf-8");
			RequestContext context = new ServletRequestContext(request);
			if (FileUpload.isMultipartContent(context)) { //判断是否有
				//创建磁盘文件工厂 
				DiskFileItemFactory disk = new DiskFileItemFactory();
				String path = request.getServletContext().getRealPath("/upload");
				System.out.println(path);
				disk.setRepository(new File(path));//设置文件存储位置
				ServletFileUpload fileUpload = new ServletFileUpload(disk);
				fileUpload.setFileSizeMax(20000000);
				fileUpload.setSizeMax(50000000);
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					if(fileItem.isFormField()){ //表示不是文件上传input
						String fieldName = fileItem.getFieldName(); //这个表示name的值
						String name = fileItem.getName();  //这个表示是文件的名字
						System.out.println(fieldName + "--"+ name);
					}else{
						String fieldName = fileItem.getFieldName();
						String name = fileItem.getName();
						System.out.println(fieldName + "--"+ name);
						File file = new File(path+"/"+name);
						InputStream in = fileItem.getInputStream();
						FileUtils.copyInputStreamToFile(in, file);
//						fileItem.write(file); 
					}
				}
				return "文件上传成功";
			}else{
				return "请选择一个文件上传";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "文件上传失败";
		}

	}

	/**
	 * 使用servlet 3.0 以上版本的文件上传
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload2")
	@ResponseBody
	private String upload2(HttpServletRequest request,HttpServletResponse response) {
		try {
			String path = request.getServletContext().getRealPath("/upload");
			log.info("upload2---------------start---------------------");
			Collection<Part> parts = request.getParts();
			log.info("upload2-parts------"+parts);
			//log.info(String format,object)的使用方法
			log.info("这个临时文件的路径是[{}]", path);
			for (Part part : parts) {
				String header = part.getHeader("Content-Disposition");
				System.out.println(header);
				//需要对header进行处理  最后一个是 filename=文件名
				int index = header.lastIndexOf("="); //获取最后一个=的索引
				String fileName = header.substring(index+1);
				System.out.println(fileName);
			}
			
//			Part part = request.getPart("file2");
//			String header = part.getHeader("Content-Disposition");
//			System.out.println(header);
//			//需要对header进行处理  最后一个是 filename=文件名
//			int index = header.lastIndexOf("="); //获取最后一个=的索引
//			String fileName = header.substring(index+1);
//			System.out.println(fileName);
			// 
//			part.write(fileName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	/**
	 * MultipartRequest 方式实现
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload3")
	@ResponseBody
	private String upload3(HttpServletRequest request,HttpServletResponse response) {

		return null;
	}

}
