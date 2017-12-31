package com.gosun.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

/**
 * 反射相关工具
 * @author cxp
 * @version 0.0.1
 */
public class ReflectUtils {
	
	/**
	 * 获取某个类的某个域的set方法
	 */
	public static Method obtainSetter(Class<?> tClass, Field field)
			throws NoSuchMethodException, SecurityException {
		String fieldName = field.getName();
		Method setMethod = null;
		try {
			setMethod = tClass.getMethod(
					"set" + StringUtils.capitalize(fieldName), field.getType());
		} catch (NoSuchMethodException e) {
			setMethod = tClass.getMethod("set" + fieldName, field.getType());
		}
		return setMethod;
	}

	/**
	 * 获取某个类的某个域的get方法
	 */
	public static Method obtainGetter(Class<? extends Object> tClass, Field field)
			throws NoSuchMethodException, SecurityException {
		String fieldName = field.getName();
		Method getMethod = null;
		try {
			if (!field.getType().equals(Boolean.class)&&!"boolean".equals(field.getType().toString())) { // 非boolean类型
				getMethod = tClass.getMethod("get"
						+ StringUtils.capitalize(fieldName));
			} else {
				getMethod = tClass.getMethod("is"
						+ StringUtils.capitalize(fieldName));
			}
		} catch (NoSuchMethodException e) {
			if (!field.getType().equals(Boolean.class)&&!"boolean".equals(field.getType().toString())) { // 非boolean类型
				getMethod = tClass.getMethod("get" + fieldName);
			} else {
				getMethod = tClass.getMethod("is" + fieldName);
			}
		}
		return getMethod;
	}
	
	/**
	 * 利用反射，将Object转换成String，String包括所有非static且非final的域
	 */
	public static String objToString(Object obj){
		Class<? extends Object> tClass=obj.getClass();
		String result="";
		for(Field field:tClass.getDeclaredFields()){
			if(field.toGenericString().contains("static")||field.toGenericString().contains("final"))
				continue;
			String fieldName=field.getName();
			result=result+fieldName+"=";
			Method getFieldMethod;
			try {
				getFieldMethod =ReflectUtils.obtainGetter(tClass, field);
				Object value=getFieldMethod.invoke(obj);
				result=result+value+"\r\n";
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
