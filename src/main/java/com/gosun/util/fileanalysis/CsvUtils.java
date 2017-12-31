package com.gosun.util.fileanalysis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gosun.util.ConfigUtils;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * csv文件相关解析工具
 * 基于opencsv
 * @author cxp
 */
public class CsvUtils {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CsvUtils.class);
	
	/**
	 * 将csv文件解析成对应Java Bean
	 */
	public static <T> List<T> analyze(String csvFilePath,Class<T> tClass){
		List<T> beans=new LinkedList<T>();
		try {
			beans = new CsvToBeanBuilder<T>(new FileReader(csvFilePath))
			   .withType(tClass).build().parse();
		} catch (IllegalStateException e) {
			LOGGER.error("解析csv文件错误，文件为"+csvFilePath,e);
		} catch (FileNotFoundException e) {
			LOGGER.error("解析csv文件错误，文件为"+csvFilePath,e);
		}
		return beans;
	}
	
	/**
	 * 将resource文件夹下的csv文件解析成对应Java Bean
	 */
	public static <T> List<T> analyzeByResource(String csvFilePath,Class<T> tClass){
		URL csvUrl=CsvUtils.class.getClassLoader().getResource(csvFilePath);
		return analyze(csvUrl.getPath(), tClass);
	}
}
