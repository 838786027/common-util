package com.gosun.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化工具
 * @author cxp
 *
 */
public class DateFormatUtils {
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static String YYYY_MM_DD_HH_MM_SS="yyyy-MM-dd HH:mm:ss";
	
	/**
	 * HH:mm:ss
	 */
	public final static String HH_MM_SS="HH:mm:ss";
	
	/**
	 * HH:mm
	 */
	public final static String HH_MM="HH:mm";
	
	/**
	 * yyyyMMdd
	 */
	public final static String YYYY_MM_DD="yyyyMMdd";
	
	/**
	 * yyyy-MM-dd
	 */
	public final static String YYYY_MM_DD_2="yyyy-MM-dd";
	
	public static DateFormat YYYY_MM_DD_HH_MM_SS(){
		return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
	}
	
	public static DateFormat HH_MM_SS(){
		return new SimpleDateFormat(HH_MM_SS);
	}
	
	public static DateFormat HH_MM(){
		return new SimpleDateFormat(HH_MM);
	}
	
	public static DateFormat YYYY_MM_DD(){
		return new SimpleDateFormat(YYYY_MM_DD);
	}
	
	public static DateFormat YYYY_MM_DD_2(){
		return new SimpleDateFormat(YYYY_MM_DD_2);
	}
	
	/**
	 * 字符串转日期
	 * @return
	 * @throws ParseException 
	 */
	public static Date strToDate(String str,String format) throws ParseException{
		DateFormat dateFormat=new SimpleDateFormat(format);
		return dateFormat.parse(str);
	}
	
	/**
	 * 日期转字符串
	 * @return
	 * @throws ParseException 
	 */
	public static String dateToStr(Date date,String format) throws ParseException{
		DateFormat dateFormat=new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
}
