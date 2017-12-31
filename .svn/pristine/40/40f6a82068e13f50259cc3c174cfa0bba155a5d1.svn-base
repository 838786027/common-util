package com.gosun.util.fileanalysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * excel文件解析相关工具
 * 
 * @author cxp
 */
public class ExcelUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ExcelUtils.class);

	/**
	 * 解析excel文件
	 */
	public static <T> List<T> analyze(File excelFile,Class<T> clazz) {
		List<T> result = new LinkedList<T>();
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(excelFile);
		} catch (EncryptedDocumentException | InvalidFormatException
				| IOException e) {
			e.printStackTrace();
			LOGGER.warn("excel文件解析异常", e);
			return result;
		}
		// sign:扩展点
		Sheet sheet = wb.getSheetAt(0);
		List<String> columnNames=new LinkedList<String>();
		int columnCount = 0;
		//读取列名
		Row row = sheet.getRow(0);
		if (row == null) {
			return result;
		} else {
			int columnNum=0;
			while(true){
				Cell cell=row.getCell(columnNum++);
				if(cell==null){
					break;
				}
				columnCount++;
				columnNames.add(cell.getStringCellValue());
			}
		}
		
		//读取行数据
		int rowNum=1;
		while(true){
			row=sheet.getRow(rowNum++);
			if(row==null){
				break;
			}
			T t=analyzeRow(row, columnNames, clazz);
			result.add(t);
		}

		return result;
	}
	
	/**
	 * 解析一行数据
	 */
	private static <T> T analyzeRow(Row row,List<String> columnNames,Class<T> clazz){
		StringBuilder rowJson=new StringBuilder();
		for(int i=0;i<columnNames.size();i++){
			Cell cell=row.getCell(i);
			if(cell==null)
				continue;
			if(StringUtils.isNoneBlank(rowJson.toString())){
				rowJson.append(",");
			}
			rowJson.append(columnNames.get(i)+":"+objToJsonValue(getCellValue(cell)));
		}
		rowJson.insert(0, "{").append("}");
		T result=JSONObject.parseObject(rowJson.toString(), clazz);
		return result;
	}
	
	/**
	 * Cell转Object
	 */
	private static Object getCellValue(Cell cell){
		switch (cell.getCellTypeEnum()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return cell.getNumericCellValue();
		default:
			break;
		}
		return null;
	}
	
	/**
	 * Object转Json值
	 */
	private static String objToJsonValue(Object obj){
		if(obj instanceof String){
			return "\""+obj+"\"";
		}
		return obj.toString();
	}
}
