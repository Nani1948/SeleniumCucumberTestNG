package com.seleniumcucumberframework.qa.seleniumdemo.svgelement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGELEMENTS {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
		  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
		  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		  //Try to inspect the element of time icon
		  //Try to inspect the time icon using absoulte path
		  //Identify the svg element using relative xpath with text method
		 // driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();
		//Identify the svg  element using relative xpath with name method
	driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active toggle']//*[name()='svg']")).click();
	}

}
