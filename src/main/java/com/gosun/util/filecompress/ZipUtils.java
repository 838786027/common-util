package com.gosun.util.filecompress;

import java.io.File;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gosun.util.ConfigUtils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import net.lingala.zip4j.util.Zip4jUtil;

/**
 * zip压缩工具
 * 
 * @author caixiaopeng
 * 
 */
public class ZipUtils {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ZipUtils.class);

	/**
	 * 压缩单个文件
	 * 
	 * @param zipedFile
	 * @param needZipFile
	 */
	public static void compress(File zipedFile, File needZipFile) {
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(zipedFile); // 压缩后文件
		} catch (ZipException e) {
			LOGGER.warn("创建ZipFile对象时异常", e);
		}
		
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // 压缩算法
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_ULTRA); // 压缩级别

		try {
			if (needZipFile.isDirectory()) {
				zipFile.createZipFileFromFolder(needZipFile.getAbsolutePath(),
						parameters, false, 1000);
			} else {
				ArrayList<File> filesToAdd = new ArrayList<File>(); // 压缩文件集合
				filesToAdd.add(needZipFile); // 需要压缩的File对象
				zipFile.addFiles(filesToAdd, parameters);
			}
		} catch (ZipException e) {
			LOGGER.warn("zip压缩文件时异常", e);
		}
	}
}
