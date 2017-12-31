package com.gosun.util;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ReflectUtilsTestCase {

	@Test
	public void testObtainSetter() throws SecurityException, IllegalArgumentException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		boolean testResult=true;
		Bean bean=new Bean();
		if(testResult&&!testSetterValue("intValue", bean, 2)){
			testResult=false;
		}
		if(testResult&&!testSetterValue("boolValue", bean, false)){
			testResult=false;
		}
		
		Assert.assertTrue(testResult);
	}
	
	private boolean testSetterValue(String FieldName,Bean instance,Object expectantValue) throws SecurityException, NoSuchFieldException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		boolean testResult=true;
		Field field=Bean.class.getDeclaredField(FieldName);
		Method setter=ReflectUtils.obtainSetter(Bean.class, field);
		if(setter!=null){
			setter.invoke(instance, expectantValue);
			Method getter=ReflectUtils.obtainGetter(Bean.class, field);
			Object value=getter.invoke(instance);
			if(!expectantValue.equals(value)){
				testResult=false;
			}
		}else{
			testResult=false;
		}
		
		return testResult;
	}

	@Test
	public void testObtainGetter() throws SecurityException, NoSuchFieldException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		boolean testResult=true;
		Bean bean=new Bean();
		if(testResult&&!testGetterValue("intValue", bean, 1)){
			testResult=false;
		}
		if(testResult&&!testGetterValue("boolValue", bean, true)){
			testResult=false;
		}
		
		Assert.assertTrue(testResult);
	}
	
	private boolean testGetterValue(String FieldName,Bean instance,Object expectantValue) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		boolean testResult=true;
		Field field=Bean.class.getDeclaredField(FieldName);
		Method getter=ReflectUtils.obtainGetter(Bean.class, field);
		if(getter!=null){
			Object value=getter.invoke(instance);
			if(!expectantValue.equals(value)){
				testResult=false;
			}
		}else{
			testResult=false;
		}
		return testResult;
	}

}

class Bean{
	private int intValue=1;
	private boolean boolValue=true;
	
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	public boolean isBoolValue() {
		return boolValue;
	}
	public void setBoolValue(boolean boolValue) {
		this.boolValue = boolValue;
	}
}
