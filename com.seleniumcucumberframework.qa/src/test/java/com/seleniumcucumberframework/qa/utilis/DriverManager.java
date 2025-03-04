package com.seleniumcucumberframework.qa.utilis;

import java.io.File;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

/*public class DriverManager {
	/*private static final Logger logger = LogManager.getLogger("DriverManager");
    private static WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<>();
    private static ExtentReports extent = null;

	    // Cucumber BeforeSuite Hook for Extent Reports setup
	    @BeforeSuite
	    public static void setup() {
	        logger.debug("DriverManager: setup: configuration started");

	        // Initialize Extent Reports
	        extent = new ExtentReports();
	        ExtentSparkReporter report = new ExtentSparkReporter(new File("target/extent-reports/extent-report.html"));
	        extent.attachReporter(report);

	        logger.debug("DriverManager: setup: configuration complete");
	    }

	    // Cucumber Before Hook to initialize WebDriver before each scenario
	    @Before
	    public void setUpDriver(Scenario scenario) {
	        logger.debug("DriverHook: setUpDriver: Hook started for scenario: " + scenario.getName());

	        // Load properties
	        PropertiesUtility prop = new PropertiesUtility();
	        Properties applicationPro = prop.loadFile("applicationData.properties");

	        // Get browser type and initialize driver
	        String browserName = applicationPro.getProperty("browser");
	        boolean isHeadless = Boolean.parseBoolean(applicationPro.getProperty("isHeadless", "false"));

	        // Initialize WebDriver
	        WebDriver driver = initializeDriver(browserName, isHeadless);
	        
	        // Set the driver to ThreadLocal for thread-safety
	        threadLocalDriver.set(driver);

	        // Create ExtentTest instance for the current scenario
	        ExtentTest test = extent.createTest(scenario.getName());
	        threadExtentTest.set(test);

	        logger.debug("DriverHook: setUpDriver: WebDriver initialized and ExtentTest configured");
	    }

	    // Initialize the WebDriver based on the browser type and headless mode
	    private WebDriver initializeDriver(String browserName, boolean isHeadless) {
	        WebDriver driver = null;
	        logger.debug("DriverManager: initializeDriver: initializing driver for browser: " + browserName + " with headless mode: " + isHeadless);
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
	                logger.error("DriverManager: initializeDriver: Unsupported browser: " + browserName);
	                break;
	        }

	        if (driver != null) {
	            driver.manage().timeouts().pageLoadTimeout(WaitConstant.PAGELOAD_WAIT_TIME);
		        driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_TIME);
		        driver.manage().window().maximize();
		        driver.manage().deleteAllCookies();
	            logger.debug("DriverManager: initializeDriver: " + browserName + " driver configured");
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

	    // Cleanup after each scenario
	    @After
	    public void tearDown(Scenario scenario) {
	        if (getDriver() != null) {
	            getDriver().quit();
	            threadLocalDriver.remove();
	            logger.debug("DriverManager: tearDown: WebDriver quit and cleaned up for scenario: " + scenario.getName());
	        }
	        if (extent != null) {
	            extent.flush(); // Flush the reports after each scenario
	        }
	        logger.debug("DriverManager: tearDown: Completed for scenario: " + scenario.getName());
	    }
}*/
