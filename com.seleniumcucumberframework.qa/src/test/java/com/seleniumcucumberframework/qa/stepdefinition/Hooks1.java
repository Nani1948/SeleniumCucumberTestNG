package com.seleniumcucumberframework.qa.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import com.seleniumcucumberframework.qa.utilis.Constants;
import com.seleniumcucumberframework.qa.utilis.DriverManagerFactory;
import com.seleniumcucumberframework.qa.utilis.ExtentReportUtility2;
import com.seleniumcucumberframework.qa.utilis.Log4JUtility;
import com.seleniumcucumberframework.qa.utilis.PropertiesUtility;
import com.seleniumcucumberframework.qa.utilis.ScreenshotUtility;
import com.seleniumcucumberframework.qa.utilis.WaitConstant;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks1 {

	
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
    @BeforeSuite
   public static void setup() {
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
	        WebDriver driver = DriverManagerFactory.initializeDriver(browserName, isHeadless);
	        
	        // Set the driver to ThreadLocal for thread-safety
	        DriverManagerFactory.setDriver(driver);
	        threadLocalDriver.set(driver);

	        // Create ExtentTest instance for the current scenario
	        extentReportUtility.createTestReport(scenario.getName());
	       
	        log.debug("DriverHook: setUpDriver: WebDriver initialized and ExtentTest configured");
		 
	   }
	 @AfterSuite
	 public void tearDown() {
	     WebDriver driver = DriverManagerFactory.getDriver();
	     if (driver != null) {
	         driver.quit();
	     }
	     if (extentReportUtility != null) {
	         extentReportUtility.endReport(); // Flush the reports after all scenarios
	     }
	     log.debug("DriverManager: tearDown: Completed");
	 }
	/* @After
	 public void removeDriver() {
	    
	     if (driver != null) {
	         driver.quit();
	     }
	   
	     log.debug("DriverManager: removeDriver: WebDriver is being reused for the next scenario");
	 }*/

	 @After
	 public void closeCurrentBrowser(Scenario scenario) {
	     WebDriver driver = DriverManagerFactory.getDriver(); // Get WebDriver instance
	     
	     if (driver != null) {
	         try {
	             // Close the current browser window (if multiple windows, it will only close the active one)
	             driver.close();
	             log.debug("Closed the current browser window.");
	         } catch (Exception e) {
	             log.error("Failed to close the browser window.", e);
	         }
	     } else {
	         log.warn("WebDriver instance is null. Cannot close the browser.");
	     }
	 }       
	    

	  @AfterStep
	    public void afterEachStep(Scenario scenario) throws IOException {
	      /*  // Log message indicating after step is executed
		  WebDriver driver = DriverManagerFactory.getDriver(); // Get the WebDriver instance

		    if (driver == null) {
		        System.out.println("WebDriver is null. Cannot take screenshot.");
		        return;
		    }


	        if (scenario.isFailed()) {
	            // Take Screenshot and attach to the scenario if it failed
	        	 try {
	            ScreenshotUtility screenshotUtility = new ScreenshotUtility();
	            String screenshotPath = screenshotUtility.getScreenshotOfThePage(driver, scenario.getName());
	            byte[] screenshot = screenshotUtility.getScreenshotAsBytes(driver);  // Capture screenshot as byte array
	            scenario.attach(Constants.SCREENSHOTS_DIRECTORY_PATH, "image/png", scenario.getName());
	        }
	        	 catch (Exception e) {
	                 e.printStackTrace();
	                 System.out.println("Failed to attach screenshot to Cucumber report.");
	             }	 
	    }*/
		   WebDriver driver = DriverManagerFactory.getDriver(); // Get WebDriver instance

	        if (driver == null) {
	            System.err.println("WebDriver instance is null. Unable to take screenshot.");
	            return;
	        }

	        if (scenario.isFailed()) {
	            try {
	                // Take a screenshot and save it as a file
	                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	                
	                // Convert the screenshot file to a byte array
	                byte[] screenshotBytes = Files.readAllBytes(screenshotFile.toPath());

	                // Attach the screenshot to the Cucumber report
	                scenario.attach(screenshotBytes, "image/png", "Failed Step Screenshot");
	                System.out.println("Screenshot attached to Cucumber report.");
	                
	            } catch (IOException e) {
	                System.err.println("Error capturing screenshot: " + e.getMessage());
	                e.printStackTrace();
	            }
	        }
	  }
}
	 
	 


