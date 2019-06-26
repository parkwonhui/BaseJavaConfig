package com.base.server.comm.util;

import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.springframework.core.io.ClassPathResource;

public class PropertiesSearch {
	private Properties properties;
	
	public PropertiesSearch(String propertiesFileName, String key) {
		if (propertiesFileName == null) {
			return;
		}
		
		try {
			StringBuilder propertiesName = new StringBuilder();
			propertiesName.append(propertiesFileName);
			propertiesName.append(" ");
			propertiesName.append(key);
			propertiesName.append(".properties");

			properties = getPropertiesFile(propertiesName.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Properties getPropertiesFile(String propertiesFileName) throws Exception {
		Properties prop = new Properties();
		Reader reader = Resources.getResourceAsReader(propertiesFileName);
		prop.load(reader);
		
		return prop;
	}
	
	public String getProperties(String key) {
		if (properties == null) {
			return null;
		}
		
		return properties.getProperty(key);
	}

}
