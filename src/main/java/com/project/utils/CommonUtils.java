package com.project.utils;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.Scenario;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_BASIC_TIME=30;
	private static Logger logger = LogManager.getLogger(CommonUtils.class);
	public static String getEmailWithTimeStamp() {
		
		Date date = new Date();
		String newEmail= "newemail"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
		logger.info("getEmailWithTimeStamp() invoked and returning new email "+newEmail);
		return newEmail;
		
	}
	public static byte[] takeScreenShot(Scenario scenario,WebDriver driver,String scenarioName) {
		byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		logger.info("takeScreenShot() invoked , screenshot taken");
		return srcScreenshot;
	}

}
