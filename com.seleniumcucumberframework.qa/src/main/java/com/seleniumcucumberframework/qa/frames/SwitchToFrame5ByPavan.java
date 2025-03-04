package com.seleniumcucumberframework.qa.frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToFrame5ByPavan {

	public static void main(String[] args) {
		/*https://ui.vision/demo/webtest/frames/
			1) switch to  5th frame
			2) click on link  - opens new iframe
			3) switch to inner frame 
			4)  check logo presence in the inner frame.*/
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://ui.vision/demo/webtest/frames/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		  driver.switchTo().frame(frame1);
		  driver.switchTo().defaultContent();
		  WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		  driver.switchTo().frame(frame2);
		  driver.switchTo().defaultContent();
		  WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		  driver.switchTo().frame(frame3);
		  driver.switchTo().defaultContent();
		  WebElement frame4=driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		  driver.switchTo().frame(frame4);
		  driver.switchTo().defaultContent();
		  WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		  driver.switchTo().frame(frame5);
		
		  WebElement clickOnLink=driver.findElement(By.xpath("//a[text()='https://a9t9.com']"));
		  js.executeScript("arguments[0].scrollIntoView(true);",clickOnLink);
		  
		  clickOnLink.click();
		  WebElement clickOnGoogleChromeButton = driver.findElement(By.xpath("(//div[@id='get']//div[@class='btn btn-primary button-download']//a)[1]"));
		  js.executeScript("arguments[0].scrollIntoView(true);", clickOnGoogleChromeButton);
		  if(clickOnGoogleChromeButton.isDisplayed()) {
			  clickOnGoogleChromeButton.click();
			  System.out.println("User click on the element");
		  }
		 
		 
		  
	}

}
