package com.seleniumcucumberframework.qa.alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://practice-automation.com/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		  
		  WebElement popup=driver.findElement(By.xpath("//a[contains(text(), 'Popups')]"));
		  popup.click();
		  Thread.sleep(1000);
		  WebElement alertPopup=driver.findElement(By.xpath("//button[@id='alert']"));
		  alertPopup.click();
		  Alert myalert=wait.until(ExpectedConditions.alertIsPresent());
		  myalert.accept();
		  
		  
		  WebElement confirmPopup=driver.findElement(By.xpath("//button[contains(@id, 'confirm')]"));
			 confirmPopup.click();
			 Alert myalert1=wait.until(ExpectedConditions.alertIsPresent());
			  myalert1.accept();
			  
			  //3.Prompt Alert-Ok and cancel , imput textbox
				 WebElement PromptPopup=driver.findElement(By.xpath("//button[@id='prompt']"));
				 PromptPopup.click();
				 Alert myalert2=wait.until(ExpectedConditions.alertIsPresent());
				 myalert2.sendKeys("hello");
				 myalert2.accept();
				 String res=driver.findElement(By.xpath("//p[@id='promptResult']")).getText();
				 if(res.contains("hello")) {
					 System.out.println("successful messages is displayed");
				 }
				 else {
					 System.out.println("successful messages is  not displayed");
				 }
	}

}
