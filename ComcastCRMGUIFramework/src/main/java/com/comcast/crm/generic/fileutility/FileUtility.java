package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProperiesFile(String key) throws IOException {
		FileInputStream fs =new FileInputStream("./configAppData/commondata.properties");
		Properties prop=new Properties();
		prop.load(fs);
		String data =prop.getProperty(key);
		return data;
		
	}

}
