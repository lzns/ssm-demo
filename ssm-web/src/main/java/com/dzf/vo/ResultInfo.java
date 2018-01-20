package com.dzf.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author dingzf
 * @date 2018年1月20日
 * @time 11:31:57
 */
public class ResultInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String code ;
	private String desc;
	private Object data;
	//解决后台类型为时间类型无法转换的问题
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public ResultInfo() {
		super();
	}
	
	public ResultInfo(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	
	public ResultInfo(String code, String desc, Object data) {
		super();
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultInfo [code=" + code + ", desc=" + desc + ", data=" + data + ", birthday=" + birthday + "]";
	}
	
	
}
