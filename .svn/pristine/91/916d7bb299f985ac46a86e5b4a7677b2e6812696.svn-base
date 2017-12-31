package com.gosun.util.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * HttpServletResponse工具
 * @author caixiaopeng
 *
 */
public class ResponseUtils {
	
	/**
	 * 编码格式
	 * 实例化常量，只可被赋值一次
	 */
	private String CHARACTER_ENCODING;
	/**
	 * 默认编码格式
	 */
	public static final String CHARACTER_ENCODING_DEFUALT="UTF-8";
	
	private static final Logger logger=LoggerFactory.getLogger(RequestUtils.class);
	
	/**
	 * 将obj以json格式打印到response输出流
	 * @param response
	 * @param result
	 */
	public void returnJson(HttpServletResponse response, Object obj) {
		returnString(response, JSONObject.toJSONString(obj));
	}
	
	/**
	 * 向response输出流打印字符串
	 * @param response
	 * @param result
	 */
	public void returnString(HttpServletResponse response, String str) {
		try {
			response.setCharacterEncoding(CHARACTER_ENCODING==null?CHARACTER_ENCODING_DEFUALT:CHARACTER_ENCODING);
			response.getWriter().println(str);
		} catch (IOException e) {
			logger.warn("HttpServletResponse返回异常",e);
		}
	}

	public String getCHARACTER_ENCODING() {
		return CHARACTER_ENCODING;
	}
	
	/**
	 * 设置编码格式
	 * @throws Exception 请勿重复赋值
	 */
	public void setCHARACTER_ENCODING(String encoding) throws Exception {
		if(CHARACTER_ENCODING==null){
			CHARACTER_ENCODING = encoding;
		}
		else {
			throw new Exception("该值只能被赋值一次，请不要重复赋值");
		}
	}
}
