package com.seleniumcucumberframework.qa.autosuggestion;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearch {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://www.google.com/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		  Actions actions=new Actions(driver);
		  WebElement clickOnSearchButton=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		  clickOnSearchButton.click();
		  Robot robot=new Robot();
		  robot.keyPress(KeyEvent.VK_S);
	        robot.keyRelease(KeyEvent.VK_S);
	        robot.keyPress(KeyEvent.VK_E);
	        robot.keyRelease(KeyEvent.VK_E);
	        robot.keyPress(KeyEvent.VK_L);
	        robot.keyRelease(KeyEvent.VK_L);
	        robot.keyPress(KeyEvent.VK_E);
	        robot.keyRelease(KeyEvent.VK_E);
	        robot.keyPress(KeyEvent.VK_N);
	        robot.keyRelease(KeyEvent.VK_N);
	        robot.keyPress(KeyEvent.VK_A);
	        robot.keyRelease(KeyEvent.VK_A);
	        // Wait for the suggestions to load
		  WebElement suggestionDropdown =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Alh6id")));	 
		  // Get all suggestion items
		  List<WebElement> suggestionItems = suggestionDropdown.findElements(By.tagName("li"));
		   // Iterate through the suggestions and click the one matching "Selena" (case-insensitive) 
		  for (WebElement suggestionItem : suggestionItems) { 
			  if (suggestionItem.getText().equalsIgnoreCase("Selena gomez age"))
			   { 
			   actions.moveToElement(suggestionItem).click().build().perform(); break; 
             }              }

	}

}
