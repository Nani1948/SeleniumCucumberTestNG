package com.seleniumcucumberframework.qa.autosuggestion;

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

public class AutosuggestionQATekarch {

	public static void main(String[] args) {
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
		  WebElement clickOnWidget=driver.findElement(By.xpath("//button[contains(text() ,'Widget')]"));
		  clickOnWidget.click();
          WebElement clickOnAutoComplete=driver.findElement(By.xpath("//a[normalize-space()='AutoComplete']"));
          clickOnAutoComplete.click();
        //input[@id='myInput']
          WebElement clickOnCountry=driver.findElement(By.xpath(" //input[@id='myInput']"));
          clickOnCountry.click();
          clickOnCountry.sendKeys("United");
         
          WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
          WebElement suggestionDropdown1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("myInputautocomplete-list")));
       List<WebElement> autoitem =suggestionDropdown1.findElements(By.tagName("div"));
       for(WebElement item:autoitem) {
    	   if(item.getText().equalsIgnoreCase("United Arab Emirates")){
    		   Actions actions=new Actions(driver);
    		   actions.moveToElement(item).click().build().perform();
    		   break;
    		   
    	   }
       }
       
	}

}
