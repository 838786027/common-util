package com.gosun.util.fileanalysis;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * json工具
 * @author cxp
 */
public class JsonUtils {
	
	/**
	 * 对象合并
	 */
	public static Map<String, Object> join(KeyValue...elements){
		assert elements!=null;
		
		Map<String, Object> result=new HashMap<String, Object>();
		for(KeyValue element:elements){
			result.put(element.getKey(), element.getValue());
		}
		return result;
	}
	
	/**
	 * 对象合并
	 */
	public static String joinToJson(KeyValue...elements){
		return JSONObject.toJSONString(join(elements));
	}
	
	/**
	 * 对象合并
	 */
	public static String joinToJson(Object...objects){
		assert objects!=null;
		
		StringBuilder result=new StringBuilder();
		for(Object object:objects){
			String json=JSONObject.toJSONString(object);
			json=json.substring(1, json.length()-1);
			if(StringUtils.isBlank(json)){
				continue;
			}
			if(StringUtils.isNotEmpty(result.toString())){
				result.append(",");
			}
			result.append(json);
		}
		return result.insert(0, "{").append("}").toString();
	}
	
	/**
	 * json键值对
	 * @author caixiaopeng
	 */
	public static class KeyValue{
		private String key;
		private Object value;
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
	}
}
