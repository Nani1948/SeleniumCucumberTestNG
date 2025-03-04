package com.seleniumcucumberframework.qa.pagination;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQATekarchTableDisplayEntryTable {

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
		  //Table
		  WebElement clickOnTable=driver.findElement(By.xpath("//a[contains(text() ,'Table')]"));
		  clickOnTable.click();
		  WebElement table=driver.findElement(By.xpath("//table"));
		  wait.until(ExpectedConditions.visibilityOf(table));
		List<WebElement>listofRows  =table.findElements(By.xpath("//tr"));
		 // Corrected Iterator declaration

		// Iterate over the rows in the table
		for (WebElement row : listofRows) {
		    // Find all cells (td) within the current row (tr)
		    List<WebElement> listofCells = row.findElements(By.xpath("td"));
		    // If the row has cells, print the text from each cell in the row
		    if (!listofCells.isEmpty()) {
		        for (WebElement cell : listofCells) {
		            System.out.print(cell.getText() + "\t"); // Print the cell text with tab space for better formatting
		        }
		        System.out.println(); // Move to the next line after each row
		    }
		}
		// Iterate over the rows in the table
		for (WebElement row : listofRows) {
		    // Find all cells (td) within the current row (tr)
		    List<WebElement> listofCells = row.findElements(By.xpath("//td[3]"));
		    if (!listofCells.isEmpty()) {
		      
		            System.out.print(((WebElement) listofCells).getText() + "\t"); // Print the cell text with tab space for better formatting
		        }
		        System.out.println(); // Move to the next line after each row
		    }
		}
		    
}
