package com.gosun.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gosun.util.os.OSinfo;
import com.gosun.util.os.PlatformLimit;

/**
 * 配置文件.properties加载工具
 * 
 * @author cxp
 */
public class ConfigUtils {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConfigUtils.class);

	/**
	 * 按目录优先级
	 * 加载配置文件
	 * 
	 * 运行根目录/config > 运行根目录 > classpath目录/config > classpath目录
	 */
	public static Properties loadConfigFileWithPriority(String configFilePath) {
		File configFile=ResourceUtils.getResourceFileWithPriority(configFilePath);
		
		try {
			FileInputStream in=new FileInputStream(configFile);
			return loadConfigFile(in);
		} catch (IOException e) {
			LOGGER.error("获取配置文件异常，对应文件为" + configFilePath, e);
		}
		return null;
	}
	
	/**
	 * 加载配置文件
	 */
	public static Properties loadConfigFile(String configFilePath){
		Reader reader = ResourceUtils.getResourceStream(configFilePath);
		try {
			return loadConfigFile(reader);
		} catch (IOException e) {
			LOGGER.error("获取配置文件异常，对应文件为" + configFilePath, e);
		}
		
		return null;
	}

	/**
	 * 加载配置文件
	 */
	public static Properties loadConfigFile(File configFile) {
		try {
			InputStream in = new FileInputStream(configFile);
			return loadConfigFile(in);
		} catch (FileNotFoundException e) {
			LOGGER.error("获取配置文件异常，对应文件为" + configFile.getAbsolutePath(), e);
		} catch (IOException e) {
			LOGGER.error("获取配置文件异常，对应文件为" + configFile.getAbsolutePath(), e);
		}
		return null;
	}

	/**
	 * 加载配置文件
	 */
	public static Properties loadConfigFile(InputStream in) throws IOException {
		Properties prop = new Properties();
		prop.load(in);
		return prop;
	}
	
	/**
	 * 加载配置文件
	 */
	public static Properties loadConfigFile(Reader reader) throws IOException {
		Properties prop = new Properties();
		prop.load(reader);
		return prop;
	}
}
