package com.seleniumcucumberframework.qa.frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://ui.vision/demo/webtest/frames/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  //Frame3
		  WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		  driver.switchTo().frame(frame1);
		  WebElement textbox=driver.findElement(By.xpath("//input[@name='mytext3']"));
		  textbox.sendKeys("Welcome");
		  //SwitchTo inner iframe(part of the frame)
		  driver.switchTo().frame(0);//switched to innerframe using iframe//<frame><iframe></iframe></frame>
		  WebElement textbox1=driver.findElement(By.xpath("//div[@id='i6']//child::div[@class='AB7Lab Id5V1']"));
		  textbox1.click();
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  WebElement checkbox1=driver.findElement(By.xpath("//div[@class='Qr7Oae']//child::div[@id='i21']"));
		  js.executeScript("arguments[0].scrollIntoView(true);", checkbox1);

		  checkbox1.click();
		  driver.switchTo().parentFrame();
		//  driver.switchTo().defaultContent();
		  WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		  driver.switchTo().frame(frame2);
		  WebElement textbox2=driver.findElement(By.xpath("//input[@name='mytext3']"));
		  textbox2.sendKeys("Welcome");
	}

}
