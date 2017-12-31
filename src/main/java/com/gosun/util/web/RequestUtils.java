package com.gosun.util.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * Http请求操作工具
 * @author cxp
 */
public class RequestUtils {
	private static final Logger LOGGER=LoggerFactory.getLogger(RequestUtils.class);
	
	/**
	 * 打印请求参数
	 * 
	 * 从0.0.2版本起，不建议使用。建议通过formatParam得到格式化后的参数值然后进行log.debug
	 */
	@Deprecated
	public static void printParam(HttpServletRequest request){
		Map<String, String[]> paramMap=request.getParameterMap();
		for(String key:paramMap.keySet()){
			System.out.print(key);
			System.out.print("=【");
			for(String value:paramMap.get(key)){
				System.out.print(" "+value);
			}
			System.out.print(" size="+paramMap.get(key).length);
			System.out.println("】");
		}
	}
	
	/**
	 * 格式化参数
	 * @return
	 */
	public static String formatParam(HttpServletRequest request){
		StringBuilder sb=new StringBuilder("\r\n--------------------------------------------------------\r\n");
		Map<String, String[]> paramMap=request.getParameterMap();
		for(String key:paramMap.keySet()){
			sb.append("|    ").append(key).append(" = [");
			for(String value:paramMap.get(key)){
				sb.append(" ").append(value);
			}
			sb.append(" ]").append(" size=").append(paramMap.get(key).length).append("\r\n");
		}
		sb.append("--------------------------------------------------------").append("\r\n");
		return sb.toString();
	}
}
