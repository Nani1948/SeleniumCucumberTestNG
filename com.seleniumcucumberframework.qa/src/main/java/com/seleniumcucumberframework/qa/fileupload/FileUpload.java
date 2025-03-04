package com.seleniumcucumberframework.qa.fileupload;
import java.awt.AWTException;
import	org.openqa.selenium.Point;
import	org.openqa.selenium.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException ,AWTException{
		  WebDriverManager.chromedriver().setup();
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
		  clickOnAccountButton.click();
		  Thread.sleep(1000);
		  Actions action=new Actions(driver);
		  WebElement clickOnFileUpload=driver.findElement(By.xpath("//*[text()='File Upload']"));
		 /* 
		  action.moveToElement(clickOnFileUpload).pause(Duration.ofSeconds(10)).click().build().perform();*/
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click()",clickOnFileUpload);
		  //Thread.sleep(1000);
		  WebElement clickOnChooseButton=driver.findElement(By.cssSelector("input#logo.classhere"));
		   //clickOnChooseButton.click();
		// js.executeScript("arguments[0].click();", clickOnChooseButton);
		 // action.moveToElement(clickOnChooseButton).pause(Duration.ofSeconds(10)).click().build().perform();
		 // wait.until(ExpectedConditions.visibilityOf(clickOnChooseButton));
		 // wait.until(ExpectedConditions.elementToBeClickable(clickOnChooseButton));
		 // js.executeScript("arguments[0].click();", clickOnChooseButton);
		 /* Robot robot=new Robot();
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);*/
	Point location  =clickOnChooseButton.getLocation();
	Dimension size = clickOnChooseButton.getSize();
	int x=location.getX()+size.getWidth()/2;
	int y=location.getY()+size.getHeight()/2;
	Robot robot=new Robot();
	robot.mouseMove(x, y);
	//robot.mousePress(InputEvent.BUTTON3_DOWN_MASK); // Press the left mouse button
	robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK); 
	// Simulate a mouse release (left button)
	robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK); // Release the left mous
//
		
		 
	}

}
