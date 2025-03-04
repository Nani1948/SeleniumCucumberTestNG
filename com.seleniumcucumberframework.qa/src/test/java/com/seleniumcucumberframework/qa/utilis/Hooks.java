package com.seleniumcucumberframework.qa.utilis;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.seleniumcucumberframework.qa.pages.BasePage;
import com.seleniumcucumberframework.qa.pages.HomePage;
import com.seleniumcucumberframework.qa.pages.LoginPage;
import com.seleniumcucumberframework.qa.utilis.ExtentReportUtility2;
import com.seleniumcucumberframework.qa.utilis.Log4JUtility;
import com.seleniumcucumberframework.qa.utilis.PropertiesUtility;
import com.seleniumcucumberframework.qa.utilis.WaitConstant;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
/*
	
    public  WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<>();
    private static final Logger log = Log4JUtility.getInstance().getLogger();
  
    protected PropertiesUtility prop=new PropertiesUtility();
    protected Properties applicationPro=prop.loadFile("applicationDataProperties");
    private static  ExtentReportUtility2 extentReportUtility = ExtentReportUtility2.getInstance();
	/*public void launchBrowser(String browserName) {
	       switch (browserName) {
	           case "firefox":
	               WebDriverManager.firefoxdriver().setup();
	               driver = new FirefoxDriver();
	               driver.manage().window().maximize();
	               break;
	           case "chrome":
	               WebDriverManager.chromedriver().setup();
	               driver = new ChromeDriver();
	               driver.manage().window().maximize();
	               break;
	       }
	       System.out.println(browserName + " browser opened");
	   }*/
   /* @BeforeSuite
  /* public static void setup() {
    	  log.debug("DriverManager: setup: configuration started");
    	  extentReportUtility.startExtentReport();
    	  log.debug("DriverManager: setup: configuration complete");
    }
	 @Before
	   public void setUpDriver(Scenario scenario) {
		 // log = logObject.getLogger();
		// Start a new test report for each scenario
	     //   extentReportUtility.createTestReport(scenario.getName());
	       //launchBrowser("chrome");
		  log.debug("DriverHook: setUpDriver: Hook started for scenario: " + scenario.getName());

	        // Load properties
	        PropertiesUtility prop = new PropertiesUtility();
	        Properties applicationPro = prop.loadFile("applicationDataProperties");

	        // Get browser type and initialize driver
	        String browserName = applicationPro.getProperty("browser");
	        boolean isHeadless = Boolean.parseBoolean(applicationPro.getProperty("isHeadless"));

	        // Initialize WebDriver
	        WebDriver driver = initializeDriver(browserName, isHeadless);
	        
	        // Set the driver to ThreadLocal for thread-safety
	        BasePage.setDriver(driver);
	        threadLocalDriver.set(driver);

	        // Create ExtentTest instance for the current scenario
	        extentReportUtility.createTestReport(scenario.getName());
	       
	        log.debug("DriverHook: setUpDriver: WebDriver initialized and ExtentTest configured");
		 
	   }
	 @AfterSuite
	 public void tearDown(Scenario scenario) {
		 if (extentReportUtility!= null) {
	        	extentReportUtility.endReport(); // Flush the reports after each scenario
	        }
	        log.debug("DriverManager: tearDown: Completed for scenario: " + scenario.getName());
	 }
	 /* @After
	    public void removeDriver(Scenario scenario) {
	        if (getDriver() != null) {
	            getDriver().quit();
	            threadLocalDriver.remove();
	            log.debug("DriverManager: tearDown: WebDriver quit and cleaned up for scenario: " + scenario.getName());
	        }
	        
	    }*/

	   /*@AfterStep
	   public void after_Each_Scenario(Scenario sc) throws IOException {
	   	sc.log("after step executed");
	   	if(sc.isFailed()) {
	   		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   		byte[] fileContent=FileUtils.readFileToByteArray(screenshot);
	   		sc.attach(fileContent, "image/png", "screenshots");
	   	}
	   }*/
	/* private WebDriver initializeDriver(String browserName, boolean isHeadless) {
	        WebDriver driver = null;
	        log.debug("DriverManager: initializeDriver: initializing driver for browser: " + browserName + " with headless mode: " + isHeadless);
	        browserName = browserName.toLowerCase();

	        switch (browserName) {
	            case "chrome":
	                ChromeOptions chromeOptions = new ChromeOptions();
	                if (isHeadless) {
	                    chromeOptions.addArguments("--headless", "--disable-gpu");
	                }
	                driver = new ChromeDriver(chromeOptions);
	             
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
	                log.error("DriverManager: initializeDriver: Unsupported browser: " + browserName);
	                break;
	        }

	        if (driver != null) {
	            driver.manage().timeouts().pageLoadTimeout(WaitConstant.PAGELOAD_WAIT_TIME);
		        driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_TIME);
		        driver.manage().window().maximize();
		        driver.manage().deleteAllCookies();
	            log.debug("DriverManager: initializeDriver: " + browserName + " driver configured");
	        }

	        return driver;
	    }
	 // Get the current WebDriver instance
	    public static WebDriver getDriver() {
	        return threadLocalDriver.get();
	    }

	    // Get the current ExtentTest instance for reporting
	    public static ExtentTest getTest() {
	        return threadExtentTest.get();
	    }
*/
}
