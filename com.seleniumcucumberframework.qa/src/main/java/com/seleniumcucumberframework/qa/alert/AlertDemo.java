package com.seleniumcucumberframework.qa.alert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import org.openqa.selenium.Alert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		/*1.In Selenium or general web automation, there are three main types of alerts (also known as pop-ups or JavaScript alerts) that you may encounter:
		 * 1. Simple Alert or JavaScript
                A simple alert contains only an OK button.
                It is typically used for displaying information or warnings.
		 *            Alert alert = driver.switchTo().alert();
                      alert.accept(); // Clicks OK

		 * 2. Confirmation Alert
                 A confirmation alert contains OK and Cancel buttons.
                 It is used to confirm an action (e.g., deleting an item).
		 *                Alert alert = driver.switchTo().alert();
                          alert.accept(); // Clicks OK
                           alert.dismiss(); // Clicks Cancel
                3. Prompt Alert: it contains two or one input box
		 *           A prompt alert contains a text box, along with OK and Cancel buttons.
                 It is used when user input is required (e.g., entering a name).
                  Example: prompt("Please enter your name:");
                 Handling in Selenium:
		 *      Alert alert = driver.switchTo().alert();
               alert.sendKeys("Test User"); // Enters text
               alert.accept(); // Clicks OK
                Alert alert = driver.switchTo().alert();
                alert.accept();//close alert box using ok button
                alert1.sendKeys()//pass the text into input box
alert.getText();capture the text value from the alert
alert.dismiss();close alert box using cancel button

		 */
		
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://practice-automation.com/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  WebElement popup=driver.findElement(By.xpath("//a[contains(text(), 'Popups')]"));
		  popup.click();
		  //1.alertbox-ok button
		  WebElement alertPopup=driver.findElement(By.xpath("//button[@id='alert']"));
		  alertPopup.click();
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
		  //2,Confirm box-ok & cancel
		 WebElement confirmPopup=driver.findElement(By.xpath("//button[contains(@id, 'confirm')]"));
		 confirmPopup.click();
		 Thread.sleep(1000);
		 Alert alert1 = driver.switchTo().alert();
		 alert1.dismiss();
		 //3.Prompt Alert-Ok and cancel , imput textbox
		 WebElement PromptPopup=driver.findElement(By.xpath("//button[@id='prompt']"));
		 PromptPopup.click();
		 Alert alert2 = driver.switchTo().alert();
		 alert2.sendKeys("hello");
		 alert2.accept();
		 String res=driver.findElement(By.xpath("//p[@id='promptResult']")).getText();
		 if(res.contains("hello")) {
			 System.out.println("successful messages is displayed");
		 }
		 else {
			 System.out.println("successful messages is  not displayed");
		 }
		 
		 //Verify the alert is present or not using WebDriverWait.
		 //2/isDisplayed or isEnabled or is isSelected is applicable for all the webelement but not for the alert.
		 
	}

}
