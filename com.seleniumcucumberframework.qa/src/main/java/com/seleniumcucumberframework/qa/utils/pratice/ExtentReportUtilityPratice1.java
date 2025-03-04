package com.seleniumcucumberframework.qa.utils.pratice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtilityPratice1 {
	 private static	ExtentReports report=null;
	 private static   ExtentSparkReporter spark=null;
	 private static   ExtentTest  test=null;
	 private  static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<>();
	 private static   ExtentReportUtilityPratice1 extentObject=null;
	 //Declare a private static instance of the class.
	 private ExtentReportUtilityPratice1() {
		 //Define private constructor to prevent mutiple instantiations.
	 }
    public static  ExtentReportUtilityPratice1   getInstance() {
		 //Provide public static method to return webdriver instance.
	  if(extentObject==null) {
		  new ExtentReportUtilityPratice1();
	  }
    	return extentObject ;
    }
	 public void startExtentReport() {
		report=new ExtentReports();
		spark=new ExtentSparkReporter("target/spark.html");
	    report.attachReporter(spark);
	    
	    //SetInFormation
	    report.setSystemInfo("HostName", " ");
	    report.setSystemInfo("Environment", "QA");
	    report.setSystemInfo("Username", "nandhini");
	    
	    spark.config().setDocumentTitle("Automation Test Script");
	    spark.config().setReportName("Regression Suite");
	    spark.config().setTheme(Theme.DARK);
		
	 
	}
    public void endReport() {
    	report.flush();
    }
    public void createTestReport(String methodName) {
    	test=report.createTest(methodName);
    	
    	
    }
    public void logTestInfo(String text) {
    	test.log(Status.INFO, MarkupHelper.createLabel(text, ExtentColor.BLUE));
    	
    }
    public void logTestPass(String text) {
    	test.log(Status.PASS, MarkupHelper.createLabel(text, ExtentColor.GREEN));
    	
    	
    }
    public void logTestFail(String text) {
    	test.log(Status.FAIL, MarkupHelper.createLabel(text, ExtentColor.RED));
    	
    	
    }
    public void logTestFailedWithException(Throwable e) {
    	test.log(Status.FAIL, e);
    	
    	
    }
    public void logTestSKIP(String text) {
    	test.log(Status.SKIP, MarkupHelper.createLabel(text, ExtentColor.ORANGE));
    	
    	
    }
    public void logTestWARN(String text) {
    	test.log(Status.WARNING, MarkupHelper.createLabel(text, ExtentColor.ORANGE));
    	
    	
    }
}
