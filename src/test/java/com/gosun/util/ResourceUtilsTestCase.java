package com.gosun.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import org.junit.Assert;
import org.junit.Test;

public class ResourceUtilsTestCase {

	@Test
	public void testGetResourceFile() {
		String filePath="test.txt";
		File file=ResourceUtils.getResourceFile(filePath);
		System.out.println(file.getAbsolutePath());
		Assert.assertNotNull(file);
	}

	@Test
	public void testGetResourceStream() {
		String filePath="test.txt";
		Reader reader=ResourceUtils.getResourceStream(filePath);
		Assert.assertNotNull(reader);
	}

}
