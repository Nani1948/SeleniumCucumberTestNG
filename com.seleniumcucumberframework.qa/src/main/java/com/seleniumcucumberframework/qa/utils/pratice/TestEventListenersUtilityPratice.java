package com.seleniumcucumberframework.qa.utils.pratice;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestEventListenersUtilityPratice implements ITestListener {
	 private static   ExtentReportUtilityPratice1 extentReport=null;
	@Override
	public void onTestStart(ITestResult result) {
	  extentReport.createTestReport(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentReport.logTestPass(result.getMethod().getMethodName()+"is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentReport.logTestFail(result.getMethod().getMethodName()+"is Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentReport.logTestSKIP(result.getMethod().getMethodName()+"is Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentReport= ExtentReportUtilityPratice1.getInstance();
		extentReport.startExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.endReport();
	}

	

}
