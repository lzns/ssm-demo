package com.dzf.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * 文件上传测试
 * @author dingzf 
 * @date 2017年11月19日
 * @time 21:29:24
 */
@Controller
@RequestMapping("load")
public class MyFileUpload {

	private static Logger log = LoggerFactory.getLogger(MyFileUpload.class);
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/upload1",produces="text/html;charset=utf-8")
	@ResponseBody
	private String upload1(HttpServletRequest request,HttpServletResponse response) {
		try {
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
	 * 单个文件上传
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/upload2",produces="text/html;charset=utf-8")
	@ResponseBody
	private String upload2(@RequestParam("file")CommonsMultipartFile partFile,HttpServletRequest request) {
			String path = request.getServletContext().getRealPath("/upload");
			String name = request.getParameter("name");
			log.info("其他的参数{}",name);
			log.info("upload2---------------start---------------------");
			log.info("这个临时文件的路径是[{}]", path);
			String filename = partFile.getOriginalFilename();
			log.info("文件的名字：{}",filename);
			File file = new File(path+"/"+filename);
			try {
				InputStream inputStream = partFile.getInputStream();
				FileUtils.copyInputStreamToFile(inputStream, file);
				if(inputStream!=null){
					inputStream.close();
				}
				return "文件上传成功！";
			}catch (Exception e) {
			e.printStackTrace();
			return "文件上传失败！";
		}
	}

	/**
	 * 单个文件上传
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/upload4",produces="text/html;charset=utf-8")
	@ResponseBody
	private String upload4(@RequestParam("file")MultipartFile partFile,HttpServletRequest request) {
		try {
			String path = request.getServletContext().getRealPath("/upload");
			String name = request.getParameter("name");
			log.info("其他的参数{}",name);
			log.info("upload2---------------start---------------------");
			log.info("这个临时文件的路径是[{}]", path);
			String filename = partFile.getOriginalFilename();
			log.info("文件的名字：{}",filename);
			File file = new File(path+"/"+filename);
			InputStream inputStream = partFile.getInputStream();
			FileUtils.copyInputStreamToFile(inputStream, file);
			if(inputStream!=null){
				inputStream.close();
			}
			return "文件上传成功！";
		} catch (Exception e) {
			e.printStackTrace();
			return "文件上传失败！";
		} 
	}
	
	/**
	 * 多个文件上载
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/upload3",produces="text/html;charset=utf-8")
	@ResponseBody
	private String upload3(@RequestParam("file")CommonsMultipartFile[] partFiles,HttpServletRequest request) {
		InputStream inputStream = null;	
		try {
			String path = request.getServletContext().getRealPath("/upload");
			String name = request.getParameter("name");
			log.info("其他的参数{}",name);
			log.info("upload2---------------start---------------------");
			log.info("这个临时文件的路径是[{}]", path);
			for (int i = 0; i < partFiles.length; i++) {
				String filename = partFiles[i].getOriginalFilename();
				log.info("文件的名字：{}",filename);
				File file = new File(path+"/"+filename);
				inputStream = partFiles[i].getInputStream();
				FileUtils.copyInputStreamToFile(inputStream, file);
			}
			if(inputStream!=null){
				inputStream.close();
			}
			return "文件上传成功！";
		} catch (Exception e) {
			e.printStackTrace();
			return "文件上传失败！";
		} 
	}
	
	/**
	 * 文件下载
	 * 单个文件下载
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/down1")
	private void down(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String path = request.getServletContext().getRealPath("/upload");
		File file = new File(path);
		File[] files = file.listFiles();
		String name = files[0].getName();
		System.out.println("文件的名字："+name);
		response.addHeader("content-disposition", "attachment;filename="+name);
		FileUtils.copyFile(files[0], response.getOutputStream());
	}
	/**
	 * 文件下载，一下次下载多个文件
	 * 思路：先将多个文件压缩到一个压缩包里去，然后传到前台
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/down2")
	private void down2(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String path = request.getServletContext().getRealPath("/upload");
		File file = new File(path);
		File[] files = file.listFiles();
		File zipFile =new File("test.zip");
		if(!zipFile.exists()){
			zipFile.createNewFile();
		}
		String zipName = zipFile.getName();
		log.info("压缩文件的名字：{}",zipName);
		response.addHeader("Content-Disposition", "attachment;filename="+zipName);
		//定义输出类型
//		response.setContentType("application/zip");
		ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile));
		BufferedInputStream in  =null;
		log.info("文件的个数{}",files.length);
		for(int i = 0;i<files.length;i++){
			String name = files[i].getName();
			System.out.println("文件的名字："+name);
			ZipEntry zipEntry = new ZipEntry(name);
			zip.putNextEntry(zipEntry);
			in = new BufferedInputStream(new FileInputStream(files[i]));
			int len = 0;
			byte [] btyes = new byte[1024*4];
			while((len=in.read(btyes))!=-1){
				zip.write(btyes, 0, len);
			}
		}
		zip.flush();
		zip.close();
		in.close();
		FileUtils.copyFile(zipFile, response.getOutputStream());
		if(zipFile.exists()){
			if(zipFile.delete()){
				log.info("压缩包删成功！！");
			}else{
				log.info("压缩包产出失败！！");
			}
			
		}
	}
	@RequestMapping(value="/test",produces="text/html;charset=utf-8")
	@ResponseBody
	public String testAjax(String name){
		
		String str = "后台成功返回:"+name;
		
		return str;
	}
}
