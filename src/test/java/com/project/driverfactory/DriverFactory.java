package com.project.driverfactory;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.project.utils.CommonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory  {

    public  static WebDriver driver ;
    private static Logger logger = LogManager.getLogger(DriverFactory.class);
    public static void initializeBrowser(String browserName)  {

        if (browserName.equals("chrome")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = WebDriverManager.chromedriver().capabilities(options).create();
//            driver= WebDriverManager.chromedriver().create();
            logger.info("chrome driver initialized");
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            logger.info("firefox  driver initialized");

        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
            logger.info("Edge driver initialized");

        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();
            logger.info("safari driver initialized");
        }

        driver.manage().deleteAllCookies();
        // driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0)); driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
    }

    public static WebDriver getDriver() {
        return driver;

    }
}
