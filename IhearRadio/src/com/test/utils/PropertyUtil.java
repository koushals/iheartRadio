package com.test.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	
	private static String fileName ;
	private static final String FILE_NAME = "\\src\\com\\test\\utils\\";
	private static Properties p;
	public PropertyUtil(String fileName) {
		PropertyUtil.fileName= fileName;
	}

	public static Properties getPropertiesFromFile(String fileName) throws Exception {
		 p= new Properties();
		InputStream is = new FileInputStream(System.getProperty("user.dir") + FILE_NAME+fileName);
		p.load(is);
		is.close();
		return p ;
	}
	
	
	public  String getPropertiesFromParameter(String parameter) throws Exception {
		 return getPropertiesFromFile(fileName).getProperty(parameter);
	}
	
	
	

}
