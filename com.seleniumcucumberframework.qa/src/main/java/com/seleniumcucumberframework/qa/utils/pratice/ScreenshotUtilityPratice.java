package com.seleniumcucumberframework.qa.utils.pratice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import freemarker.template.utility.Constants;

public class ScreenshotUtilityPratice {

	public static void takeScreenshot(WebDriver driver, String filePath) throws IOException {
		File screenCapture=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File(filePath);
		FileUtils.copyFile(screenCapture, destFile);
	}

}
