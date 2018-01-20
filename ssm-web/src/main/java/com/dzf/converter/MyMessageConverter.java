package com.dzf.converter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.alibaba.fastjson.JSONObject;
import com.dzf.vo.ResultInfo;
/**
 * 自定义消息转换器
 * @author dingzf
 * @date 2018年1月20日
 * @time 19:26:39
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<ResultInfo> {

		
	public MyMessageConverter(){
		super(Charset.forName("utf-8"),new MediaType("application","x-result"));
	}
	
	//所映射的model
	@Override
	protected boolean supports(Class<?> clazz) {
		return ResultInfo.class.isAssignableFrom(clazz);
	}

	@Override
	protected ResultInfo readInternal(Class<? extends ResultInfo> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		String copyToString = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("utf-8"));
		ResultInfo result = (ResultInfo)JSONObject.parse(copyToString);
		return result;
	}

	@Override
	protected void writeInternal(ResultInfo t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String str = t.getCode()+"-"+t.getDesc();
		outputMessage.getBody().write(str.getBytes());
	}

}
