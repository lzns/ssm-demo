package com.dzf.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *	邮件发送工具类 
 * @author dingzf
 * @date 2018年1月21日
 * @time 11:43:40
 */
public class SendEmailUtil implements Runnable {
	private static Logger log =  LoggerFactory.getLogger(SendEmailUtil.class);
	private static Properties prop = new Properties();
	private List<String> toEmilList = new ArrayList<String>();//用于指定收件人的邮箱
	private List<String> ccEmilList = new ArrayList<String>();//用于抄送的收件人的邮箱
	public List<String> getCcEmilList() {
		return ccEmilList;
	}
	public void setCcEmilList(List<String> ccEmilList) {
		this.ccEmilList = ccEmilList;
	}
	public SendEmailUtil(List<String> toEmilList, List<String> ccEmilList) {
		super();
		this.toEmilList = toEmilList;
		this.ccEmilList = ccEmilList;
	}
	public List<String> getToEmilList() {
		return toEmilList;
	}
	public void setToEmilList(List<String> emilList) {
		this.toEmilList = emilList;
	}
	public SendEmailUtil(List<String> emilList) {
		super();
		this.toEmilList = emilList;
	}
	
	public SendEmailUtil() {
		super();
	}
	static{
		InputStream in = SendEmailUtil.class.getClassLoader().getResourceAsStream("emil_config.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("读取配置失败，异常信息{}",e);
			throw new RuntimeException("读取邮件配置文件失败");
		}
	}
	@Override
	public void run() {
		try {
			log.info("邮件创建开始了。。。。");
			//1.创建session
			Session session = Session.getInstance(prop);
			//2.开启session的debug模式，可以查看出email发送的情况
			session.setDebug(true);
			//3.连接发件服务器
			Transport trans = session.getTransport();
			trans.connect(prop.getProperty("mail.host"),prop.getProperty("mail.name"), prop.getProperty("mail.password"));
			//4.创建邮件
			Message message = createMessageMail(session);
			//发送邮件
			trans.sendMessage(message, message.getAllRecipients());
			trans.close();
		} catch (Exception e) {
			log.error("创建邮件发生异常：异常为{}",e.toString());
			e.printStackTrace();
		}
	}
	/**
	 * 组装邮件
	 * @param session
	 */
	private Message createMessageMail(Session session)throws Exception {
		//创建邮件对象
		MimeMessage mimeMessage = new MimeMessage(session);
		//设置邮件的基本信息
		//发件人
		mimeMessage.setFrom(new InternetAddress(prop.getProperty("mail.from")));
		//收件人
		InternetAddress[] addressTo = new InternetAddress[toEmilList.size()];
		for(int i =0 ;i<toEmilList.size();i++){
			addressTo[i]=new InternetAddress(toEmilList.get(i));
		}
		//抄送人
		InternetAddress[] addressCc = new InternetAddress[ccEmilList.size()];
		for(int i =0 ;i<ccEmilList.size();i++){
			addressCc[i]=new InternetAddress(ccEmilList.get(i));
		}
		mimeMessage.setRecipients(Message.RecipientType.TO, addressTo);
		if(ccEmilList.size()>0){
			mimeMessage.setRecipients(Message.RecipientType.CC, addressCc);
		}
		//邮件标题
		mimeMessage.setSubject("私人定制-系统通知");
		
		//邮件正文
		MimeBodyPart bodyPart = new MimeBodyPart();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String str = simple.format(date);
		bodyPart.setContent("亲爱得用户:<br/>&nbsp;&nbsp;&nbsp;&nbsp;<p>你好，你与"+str+"登录私人定制，如果不是本人登录，你的密码可能已经泄露！请立即前往官网修改密码。如果是你非别人登录，请你忽略此消息!谢谢！</p>","text/html;charset=utf-8");
		//TODO添加附件，图片之类
		MimeBodyPart attach = new MimeBodyPart();
		File file = new File("e:/generatorConfig.xml");
		DataHandler dh= new DataHandler(new FileDataSource(file));
		attach.setDataHandler(dh);
		
		//描述数据关系
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		multipart.addBodyPart(attach);
		mimeMessage.setContent(multipart);
		mimeMessage.saveChanges();
		return mimeMessage;
	}
	public static void main(String[] args) {
		List<String> toEmilList = new ArrayList<String>();
		toEmilList.add("871623319@qq.com");
		toEmilList.add("1522239686@qq.com");
		List<String> ccEmilList = new ArrayList<String>();
		ccEmilList.add("944879285@qq.com");
		SendEmailUtil email = new SendEmailUtil(toEmilList, ccEmilList);
		new Thread(email).start();//启动一个线程
	}
}
