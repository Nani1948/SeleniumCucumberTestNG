package com.seleniumcucumberframework.qa.utilis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtility2 {
	private static ExtentReports report;
	private static ExtentSparkReporter spark;
	private static ExtentTest test;
	private static ExtentReportUtility2 extentObject;
	private static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<>();
	public static synchronized ExtentReportUtility2 getInstance() {
        if (extentObject == null) {
            extentObject= new ExtentReportUtility2();       
        }
        return extentObject;
	}
	 public void startExtentReport() {
		  // Create a spark report and attach it to the extent report
		 spark = new ExtentSparkReporter(Constants.SPARK_HTML_REPORT_PATH);
		 report = new ExtentReports();
		 report.attachReporter(spark); 
		 // Set system information
		  report.setSystemInfo("HostName", "Value");
	      report.setSystemInfo("Environment", "SalesforceQA");
	      report.setSystemInfo("Username", "Nandi");
	    // set document title
	      spark.config().setDocumentTitle("Test Execution");
	      spark.config().setReportName("Regression");
	      spark.config().setTheme(Theme.STANDARD);
	 }
	 public ExtentTest createTestReport(String methodName) {
		test =report.createTest(methodName);
	   threadExtentTest.set(test);
		extentObject=this;
		 return test; 
	 }
	 public void endReport() {
		 report.flush();
	 }
	 public void logTestInfo(String text) {
	        if (test != null) {
	            test.log(Status.INFO, text);
	            test.info(text);
	        } else {
	            System.out.println("Test logger not initialized. Please call startSingleTestReport() first.");
	        }
	    }

	    public void logTestPass(String text) {
	        test.log(Status.PASS, MarkupHelper.createLabel(text, ExtentColor.GREEN));
	    }

	    public void logTestFail(String text) {
	        test.log(Status.FAIL, MarkupHelper.createLabel(text, ExtentColor.RED));
	    }

	    public void logTestSkip(String text) {
	        test.log(Status.SKIP, MarkupHelper.createLabel(text, ExtentColor.ORANGE));
	    }

	    public void logTestWarning(String text) {
	        test.log(Status.WARNING, text);
	        test.info(text);
	    }

	    public void logTestFailedWithException(Throwable e) {
	        test.log(Status.FAIL, e);
	    }

	    public void logTestFailedWithScreenshot(String path) {
	        test.addScreenCaptureFromPath(path);
	    }
	    public static void setTest(ExtentTest test) {
	        threadExtentTest.set(test);
	    }
	    public static ExtentTest getTest() {
	        return threadExtentTest.get();
	    }
}
