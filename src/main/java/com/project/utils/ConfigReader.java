package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConfigReader {
	private static Logger logger = LogManager.getLogger(ConfigReader.class);
	public Properties intializeProperties() {
		
		Properties prop = new Properties();
		File proFile = new File(System.getProperty("user.dir")+FilePath.getConfigPropertyFilePath());
		
		try {
			FileInputStream fis = new FileInputStream(proFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		logger.info("read property file ");
		return prop;
		
	}

}
