package com.seleniumcucumberframework.qa.frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://ui.vision/demo/webtest/frames/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  try {
		  WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		  driver.switchTo().frame(frame1);
		  WebElement textbox=driver.findElement(By.xpath("//input[@name='mytext1']"));
		  textbox.sendKeys("Welcome");
			 // We can't directly switch frame1 to frame2.
		  driver.switchTo().defaultContent();//frame1 to moved frames 2 by using defaultContent() then
	
		  WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		  driver.switchTo().frame(frame2);
		  WebElement textbox1=driver.findElement(By.xpath("//input[@name='mytext2']"));
		  textbox1.sendKeys("Welcome");
		  driver.switchTo().defaultContent();
		  WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		  driver.switchTo().frame(frame3);
		  WebElement textbox2=driver.findElement(By.xpath("//input[@name='mytext3']"));
		  textbox2.sendKeys("Welcome");
		  }
		  catch(ElementNotInteractableException e) {
			  e.printStackTrace();
		  }
		  //driver.switchTo().defaultContent();
		  
	
		  
	}

}
