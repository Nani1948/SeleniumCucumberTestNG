package com.seleniumcucumberframework.qa.utilis;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.seleniumcucumberframework.qa.pages.BasePage;






public class TestEventListenerUtility implements ITestListener{
	 protected ExtentReportUtility2 extentReport;
	    private static final Logger log =  Log4JUtility.getInstance().getLogger();
	
	 @Override
	    public void onStart(ITestContext context) {
	        extentReport = ExtentReportUtility2.getInstance();
	        log.info("Extent Report initialized.");
	        extentReport.startExtentReport();
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        extentReport.createTestReport(result.getMethod().getMethodName());
	        log.info("Starting test: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        log.info(result.getMethod().getMethodName() + " is passed");
	        extentReport.logTestPass(result.getMethod().getMethodName() + " is passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	log.error(result.getMethod().getMethodName() + " is failed");
	        extentReport.logTestFail(result.getMethod().getMethodName() + " is failed");
	        extentReport.logTestFailedWithException(result.getThrowable());
	        // Handle Retry Log
	        if (result.getMethod().getRetryAnalyzer(result) != null) {
	        	 RetryAnalyzer retryAnalyzer = (RetryAnalyzer) result.getMethod().getRetryAnalyzer(result);
	             if (retryAnalyzer.retry(result)) {
	                 log.warn(result.getMethod().getMethodName() + " is being retried...");
	                 extentReport.logTestInfo(result.getMethod().getMethodName() + " is being retried...");
	                 return; // Exit early if retrying
	             } else {
	                 log.error(result.getMethod().getMethodName() + " failed after retries.");
	             }
	         }
	       

	        // Take Screenshot and Attach to Report
	         WebDriver driver = DriverManagerFactory.getDriver();
	        if (driver != null) {
	            ScreenshotUtility screenshotUtility = new ScreenshotUtility();
	            String screenshotPath = screenshotUtility.getScreenshotOfThePage(driver, result.getMethod().getMethodName());
	            
	         if (screenshotPath != null) {
	            extentReport.logTestFailedWithScreenshot(screenshotPath); // Attach screenshot
	        } else {
	            log.error("Screenshot path is null. Unable to attach screenshot.");
	        }
	    } else {
	        log.error("WebDriver instance is null. Unable to capture screenshot.");
	    }
	     
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        log.warn(result.getMethod().getMethodName() + " is skipped");
	        extentReport.logTestSkip(result.getMethod().getMethodName() + " is skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        log.info("Finalizing Extent Report...");
	        extentReport.endReport();
	    }

}
