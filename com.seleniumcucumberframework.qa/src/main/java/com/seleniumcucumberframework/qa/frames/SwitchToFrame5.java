package com.seleniumcucumberframework.qa.frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToFrame5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://ui.vision/demo/webtest/frames/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  JavascriptExecutor js = (JavascriptExecutor) driver;
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
			  WebElement textbox3=driver.findElement(By.xpath("//input[@name='mytext3']"));
			  textbox3.sendKeys("Welcome");
			//  driver.switchTo().defaultContent();
			  
			  //SwitchTo inner iframe(part of the frame)
			  driver.switchTo().frame(0);//switched to innerframe using iframe//<frame><iframe></iframe></frame>
			  //js.executeScript("window.scrollBy(0, 500);");

		        // Scroll down again inside the iframe
		       js.executeScript("window.scrollBy(0, 200);");
			 //js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
		      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			  WebElement checkbox= wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@id='i6']//child::div[@class='AB7Lab Id5V1']"))));
			       
			  checkbox.click();
			 
			  WebElement checkbox1=driver.findElement(By.xpath("//div[@class='Qr7Oae']//child::div[@id='i21']"));
			  js.executeScript("window.scrollBy(0, 200);");

			  checkbox1.click();
			  driver.switchTo().parentFrame();
			 driver.switchTo().defaultContent();
			  WebElement frame4=driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
			  driver.switchTo().frame(frame4);
			  WebElement textbox4=driver.findElement(By.xpath("//input[@name='mytext4']"));
			  textbox4.sendKeys("Welcome");
			  driver.switchTo().defaultContent();
			

			  WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
			  driver.switchTo().frame(frame5);
			 
			  WebElement textbox5=driver.findElement(By.xpath("//input[@name='mytext5']"));
			
			  textbox5.sendKeys("Welcome");
			  driver.switchTo().defaultContent();
			  }
			  catch(ElementNotInteractableException e) {
				  e.printStackTrace();
			  }
			  //driver.switchTo().defaultContent();
	}

}
