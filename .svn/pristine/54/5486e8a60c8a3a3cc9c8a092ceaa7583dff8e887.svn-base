package com.gosun.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.gosun.util.os.OSinfo;
import com.gosun.util.os.PlatformLimit;

/**
 * 资源文件工具
 * 
 * @author caixiaopeng
 * @version 0.0.1
 */
public class ResourceUtils {
	
	public static String getResourceRoot(){
		return ResourceUtils.class.getClassLoader().getResource("").getPath();
	}

	/**
	 * 获取Maven结构下的resources文件
	 */
	public static File getResourceFile(String filePath) {
		URL uri = ResourceUtils.class.getClassLoader().getResource(filePath);
		File file = new File(uri.getPath());
		return file;
	}

	/**
	 * 获取Maven结构下的resources文件，以数据流的形式
	 */
	public static Reader getResourceStream(String filePath) {
		InputStream in=ResourceUtils.class.getClassLoader().getResourceAsStream(filePath);
		return new InputStreamReader(in, Charset.forName("UTF-8"));
	}

	/**
	 * 按目录优先级 获取资源文件
	 * 运行根目录/config > 运行根目录 > classpath目录/config > classpath目录
	 */
	public static File getResourceFileWithPriority(String configFilePath) {
		// 获取运行根目录和根目录下的config目录
		String runRootDir = System.getProperty("user.dir");
		String limit = null;
		if (OSinfo.isWindows()) {
			limit = PlatformLimit.WINDOWS_LIMIT;
		} else if (OSinfo.isLinux()) {
			limit = PlatformLimit.LINUX_LIMIT;
		} else {
			limit = null;
		}

		// 获取运行根目录下的资源文件
		File file = null;
		file = new File(runRootDir + limit + "config" + limit + configFilePath);

		// 获取运行根目录
		if (!file.exists()) {
			if (StringUtils.isNoneBlank(runRootDir) && limit != null) {
				file = new File(runRootDir + limit + configFilePath);
			}
		}

		// 获取classpath目录下的config
		if (!file.exists()) {
			if (limit != null) {
				try{
					file = getResourceFile("config" + limit + configFilePath);
				}catch (Exception e) {
				}
			}
		}

		// 获取classpath目录
		if (!file.exists()) {
			file = getResourceFile(configFilePath);
		}
		
		return file;
	}
}
