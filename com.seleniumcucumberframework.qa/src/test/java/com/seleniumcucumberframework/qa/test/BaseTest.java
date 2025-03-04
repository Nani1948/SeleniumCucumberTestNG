package com.seleniumcucumberframework.qa.test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.seleniumcucumberframework.qa.utilis.Constants;
import com.seleniumcucumberframework.qa.utilis.PropertiesUtility;
import com.seleniumcucumberframework.qa.utilis.WaitConstant;




public class BaseTest {
    public  static  WebDriver driver;
	   public  static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	    public static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<>();
	    public static  ExtentReports extent = null;
	    public static ExtentTest test;
         public static Logger logger = LogManager.getLogger("BaseTest");
    @BeforeSuite
    public void setup() {
    	logger.debug("BaseTest: setup: configuration started ");
        extent = new ExtentReports();
        ExtentSparkReporter report = new ExtentSparkReporter(new File(Constants.SPARK_HTML_REPORT_PATH));
        extent.attachReporter(report);
		logger.debug("BaseTest: setup: configuration complete");
    	
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
        logger.debug("BaseTest: tearDown: completed ");
    }

	  @org.testng.annotations.Parameters({"browserName", "isHeadless"})
	    @BeforeMethod
	    public void setUpDriver(@Optional("chrome")String browserName,@Optional("false") boolean isHeadless,Method name) {
	        PropertiesUtility prop = new PropertiesUtility();
	        Properties applicationPro = prop.loadFile("data.properties");
	       driver =BaseTest.getBrowserType(applicationPro.getProperty("browser"), isHeadless);
	        
	        
	        logger.debug("BaseTest: setDriver: driver configuration done");
	        threadLocalDriver.set(driver);
	        logger.debug("BaseTest: setDriver: driver saved on to a threadlocal object");
	        test = extent.createTest(name.getName());
	        logger.debug("BaseTest: setDriver: test object created");
	    }

	    /*@AfterMethod
	    public void removeDriver() {
			if (threadLocalDriver.get() != null) {
	            threadLocalDriver.get().quit();
	        }
	        threadLocalDriver.remove();
	        logger.debug("BaseTest: removeDriver: driver configuration removed from the thread");
	    }*/
	  

  
    public static WebDriver getDriver() {
    	logger.debug("BaseTest: getDriver: driver configuration retrived by the thread");
        return threadLocalDriver.get();
    }

    public static WebDriver getBrowserType(String browserName, boolean isHeadless) {
        browserName = browserName.toLowerCase();
        WebDriver driver;
        switch (browserName) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if (isHeadless) {
                    options.addArguments("--headless", "--disable-gpu");
                   
                }
                driver = new ChromeDriver(options);		          
                break;
            case "safari":
                driver = new SafariDriver();                
                break;
            case "edge":
                driver = new EdgeDriver();            
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = null;
                logger.error("BaseTest: getBrowserType: Unsupported browser name: " + browserName);
                break;
        }
        if (driver != null) {
            driver.manage().timeouts().pageLoadTimeout(WaitConstant.PAGELOAD_WAIT_TIME);
            driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_TIME);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            logger.debug("BaseTest: getBrowserType: " + browserName + " driver configured");
        }
        return driver;
    }
}
