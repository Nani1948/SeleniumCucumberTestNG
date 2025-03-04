package com.seleniumcucumberframework.qa.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://www.google.com/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  
		  WebElement clickOnSearchButton=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		  clickOnSearchButton.click();
		  //clickOnSearchButton.sendKeys("Selenium");
		  /*Robot robot=new Robot();
		  robot.keyPress(KeyEvent.VK_S);
		  robot.keyRelease(KeyEvent.VK_S);
		  robot.keyPress(KeyEvent.VK_E);
		  robot.keyRelease(KeyEvent.VK_E);
		  robot.keyPress(KeyEvent.VK_L);
		  robot.keyRelease(KeyEvent.VK_L);
		  robot.keyPress(KeyEvent.VK_L);
		  robot.keyRelease(KeyEvent.VK_L);
		  robot.keyPress(KeyEvent.VK_L);
		  robot.keyRelease(KeyEvent.VK_L);*/
		
		  
		  /*JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].value='Selenium'",clickOnSearchButton );*/
		  
		  Actions action =new Actions(driver);
		  action.moveToElement(clickOnSearchButton).sendKeys("Selenium").build().perform();
		  
		  
	}

}
