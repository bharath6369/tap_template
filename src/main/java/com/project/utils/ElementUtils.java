package com.project.utils;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	long durationInSeconds=CommonUtils.EXPLICIT_WAIT_BASIC_TIME;
	private static Logger logger = LogManager.getLogger(ElementUtils.class);
	public ElementUtils(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void clickElement(WebElement element) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		logger.info("clickOnElement(), invoked and clicked on element "+element);
		
	}
	


	public void clearAndSendKeys(WebElement element,String textToBeTyped) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		logger.info("clearAndSendKeys(), invoked and enter text  "+textToBeTyped +" in "+element);
	}
	

	public void clearElement(WebElement element) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.clear();
		logger.info("clearElement() in"+element);
	}
		
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		logger.info(element+ " element is clickable");
		return webElement;
		
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
		logger.info("selectOptionInDropdown(), invoked , value selected from dropdown "+dropDownOption);
	}
	
	public void acceptAlert() {
		
		Alert alert = waitForAlert();
		alert.accept();
		logger.info("alert accepted successfully");
		
	}
	
	public void dismissAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert();
		alert.dismiss();
		logger.info("alert dismiss successfully");
	}
	
	public Alert waitForAlert() {
		
		Alert alert = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		logger.info("waiting for the alert");
		return alert;
		
	}
	
	public void mouseHoverAndClick(WebElement element) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);	
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		logger.info("mousehover on element "+element+" and clicked");
		
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		logger.info("waiting for the element visibility");
		return webElement;
		
	}
	
	public void javaScriptClick(WebElement element) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webElement);
		logger.info("clicked on element using javascriptexecutor");
	}
	
	public void javaScriptType(WebElement element,String textToBeTyped) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement);
		logger.info("enter text in textbox using  javascriptexecutor");
	}
	
	public String getElementText(WebElement element) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		logger.info("getting text from webpage "+webElement.getText());
		return webElement.getText();
		
	}
	
	public boolean isElementDisplayed(WebElement element) {
		
		try {
			WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
			return webElement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
		
	}
	
}
