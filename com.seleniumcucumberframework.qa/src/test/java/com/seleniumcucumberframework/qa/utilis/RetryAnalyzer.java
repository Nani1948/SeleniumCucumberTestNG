package com.seleniumcucumberframework.qa.utilis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retryCount = 0;
	private static final int maxRetryCount = 2; 
	private static final Logger log = LoggerFactory.getLogger(RetryAnalyzer.class);
	@Override
	public boolean retry(ITestResult result) {
		 if (retryCount < maxRetryCount) {
	            log.warn("Retrying test: " + result.getMethod().getMethodName() + " (Attempt " + (retryCount + 1) + ")");
	            retryCount++;
	            return true;
	        }
		return false;
	}

}
