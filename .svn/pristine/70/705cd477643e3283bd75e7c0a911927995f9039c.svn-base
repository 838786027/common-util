package com.gosun.util.fileanalysis;

import static org.junit.Assert.*;

import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.gosun.util.DateFormatUtils;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class CSVUtilsTestCase {

	@Test
	public void testAnalyze() throws ParseException {
		boolean testResult=true;
		String csvFilePath="test.csv";
		List<Bean> beans=CsvUtils.analyzeByResource(csvFilePath, Bean.class);
		
		System.out.println(beans);
		if(beans!=null){
			List<Bean> testSet=getTestSet();
			if(beans.size()==testSet.size()){
				for(int i=0;i<beans.size();i++){
					if(!beans.get(i).equals(testSet.get(i))){
						testResult=false;
						break;
					}
				}
			}else{
				testResult=false;
			}
		}else{
			testResult=false;
		}
		
		Assert.assertTrue(testResult);
	}
	
	private List<Bean> getTestSet() throws ParseException{
		List<Bean> testSet=new LinkedList<Bean>();
		Bean bean=new Bean();
		bean.setId("1");
		bean.setIntValue(1);
		bean.setStrValue("string");
		Date dateValue=DateFormatUtils.strToDate("2017-06-20T10:32:48Z", "yyyy-MM-dd'T'HH:mm:ss'Z'");
		bean.setDateValue(dateValue);
		testSet.add(bean);
		bean=new Bean();
		bean.setId("2");
		bean.setIntValue(2);
		bean.setStrValue("string2");
		dateValue=DateFormatUtils.strToDate("2017-06-20T10:32:52Z", "yyyy-MM-dd'T'HH:mm:ss'Z'");
		bean.setDateValue(dateValue);
		testSet.add(bean);
		System.out.println("测试集=【"+testSet+"】");
		return testSet;
	}
}