package com.gosun.util.fileanalysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlUtils {
	private static final Logger LOGGER=LoggerFactory.getLogger(XmlUtils.class);
	
	public static Document analyzeText(String xml){
		Document doc=null;
		try {
			doc=DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
			LOGGER.error("解析xml异常",e);
		}
		return doc;
	}
	
	public static Document analyzeInputStream(InputStream in){
		StringBuilder xml=new StringBuilder();
		byte[] buf=new byte[1024];
		while(true){
			int len=-1;
			try {
				len=in.read(buf);
			} catch (IOException e) {
			}
			if(len==-1){
				break;
			}
			xml.append(new String(buf, 0, len));
		}
		
		return analyzeText(xml.toString());
	}
	
	public static Document analyzeFile(String filePath){
		File file=new File(filePath);
		FileInputStream in=null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			LOGGER.error("读取文件异常",e);
			return null;
		}
		StringBuilder xml=new StringBuilder();
		byte[] buf=new byte[1024];
		while(true){
			int len=-1;
			try {
				len=in.read(buf);
			} catch (IOException e) {
			}
			if(len==-1){
				break;
			}
			xml.append(new String(buf, 0, len));
		}
		
		Document doc=null;
		try {
			doc=DocumentHelper.parseText(xml.toString());
		} catch (DocumentException e) {
			e.printStackTrace();
			LOGGER.error("解析xml文件（"+filePath+"）异常",e);
		}
		return doc;
	}
	
	/**
	 * 从classpath（resource）处加载并解析xml文件
	 */
	public static Document analyzeFileFromResource(String filePath){
		InputStream in=XmlUtils.class.getClassLoader().getResourceAsStream(filePath);
		StringBuilder xml=new StringBuilder();
		byte[] buf=new byte[1024];
		while(true){
			int len=-1;
			try {
				len=in.read(buf);
			} catch (IOException e) {
			}
			if(len==-1){
				break;
			}
			xml.append(new String(buf, 0, len));
		}
		
		Document doc=null;
		try {
			doc=DocumentHelper.parseText(xml.toString());
		} catch (DocumentException e) {
			e.printStackTrace();
			LOGGER.error("解析xml文件（"+filePath+"）异常",e);
		}
		return doc;
	}
}
