package com.gosun.util;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

public class ConfigUtilsTestCase {

	@Test
	public void testLoadConfigFileString() {
		String configFilePath="application.properties";
		Properties prop=ConfigUtils.loadConfigFile(configFilePath);
		boolean testResult=true;
		if(prop!=null){
			if(!"123".equals(prop.getProperty("A"))){
				testResult=false;
			}
			if(testResult&&!"456".equals(prop.getProperty("A.B"))){
				testResult=false;
			}
			if(testResult&&!"789".equals(prop.getProperty("A.B.C"))){
				testResult=false;
			}
		}else{
			testResult=false;
		}
		Assert.assertTrue("ConfigUtils.loadConfigFileString success", testResult);
	}

	@Test
	public void testLoadConfigFileFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadConfigFileInputStream() {
		fail("Not yet implemented");
	}

}
