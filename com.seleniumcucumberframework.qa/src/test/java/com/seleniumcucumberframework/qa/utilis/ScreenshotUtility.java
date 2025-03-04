package com.seleniumcucumberframework.qa.utilis;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	public String getScreenshotOfThePage(WebDriver driver, String testName) {
		   if (driver == null) {
	            System.out.println("WebDriver instance is null. Cannot capture screenshot.");
	            return null;
		   }
		  
	 
	    
	    try {
	    	   // Create a timestamp
		    String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		    TakesScreenshot screenshot = (TakesScreenshot) driver;
		    File imgFile = screenshot.getScreenshotAs(OutputType.FILE);
		    
		    // Set the destination path
		    String screenshotPath = Constants.SCREENSHOTS_DIRECTORY_PATH + testName + "_" + timestamp + ".png";
		    File destFile = new File(screenshotPath);
	        FileUtils.copyFile(imgFile, destFile);
	        System.out.println("Screenshot saved: " + screenshotPath);
	        return screenshotPath;
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Failed to save screenshot.");
	        return null;
	    }
	    
	
}
	// Capture screenshot and return as byte array (for attaching to reports)
	public byte[] getScreenshotAsBytes(WebDriver driver) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0]; // Return empty byte array if screenshot fails
        }
    }
    }
