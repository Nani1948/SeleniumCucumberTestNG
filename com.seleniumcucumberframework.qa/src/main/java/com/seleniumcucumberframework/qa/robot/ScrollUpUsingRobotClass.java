package com.seleniumcucumberframework.qa.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollUpUsingRobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		/* WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  driver.get("https://qa-tekarch.firebaseapp.com");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement email=driver.findElement(By.xpath("//input[@id='email_field']"));
		  email.click();
		  email.sendKeys("admin123@gmail.com");
		  
		  WebElement password=driver.findElement(By.xpath("//input[@id='password_field']"));
		  password.click();
		  password.sendKeys("admin123");
		  
		  WebElement clickOnAccountButton=driver.findElement(By.xpath("//button[text()='Login to Account']"));
		  clickOnAccountButton.click();*/
		 WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  driver.get("https://www.google.com/");
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  Robot robot=new Robot();
		  Thread.sleep(1000);
		  robot.mouseWheel(1);//robot.mouseWheel(1): Scrolls the mouse wheel up by one notch.
		  robot.mouseWheel(-1); //Scrolls the mouse wheel down by one notch.
		  
	}

}
