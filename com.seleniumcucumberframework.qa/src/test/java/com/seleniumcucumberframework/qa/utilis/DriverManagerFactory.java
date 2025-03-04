package com.seleniumcucumberframework.qa.utilis;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentTest;

public class DriverManagerFactory {
	private static WebDriver driver=null;
	private static final Logger log = Log4JUtility.getInstance().getLogger();
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	 private static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<>();
   
    // Method to initialize WebDriver based on the browser name and headless setting
    public static WebDriver initializeDriver(String browserName, boolean isHeadless) {
    	

    	log.debug("DriverManagerFactory: initializeDriver: initializing driver for browser: " + browserName + " with headless mode: " + isHeadless);
        browserName = browserName.toLowerCase();

        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless", "--disable-gpu");
                }
                chromeOptions.addArguments("--disable-notifications");  // Disable notifications
                chromeOptions.addArguments("--disable-infobars");// Disable the info bar
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
                log.error("DriverManagerFactory: initializeDriver: Unsupported browser: " + browserName);
                break;
        }

        if (driver != null) {
            driver.manage().timeouts().pageLoadTimeout(WaitConstant.PAGELOAD_WAIT_TIME);
            driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_TIME);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            log.debug("DriverManagerFactory: initializeDriver: " + browserName + " driver configured");
        }
        threadLocalDriver.set(driver); 
        return driver;
    }
 // Get the current WebDriver instance
    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }
    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    // Get the current ExtentTest instance for reporting
    public static ExtentTest getTest() {
        return threadExtentTest.get();
    }
   /* public  WebDriver getWebDriver() {
        return driver; }
    public  void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
    }*/
}
