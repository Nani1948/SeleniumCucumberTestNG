package com.seleniumcucumberframework.qa.pagination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadTheDataFromTheRow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		//WebElement
		 WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		 username.clear();
		 username.sendKeys("demo");
		 WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
		 password.clear();
		 password.sendKeys("demo");
		 WebElement loginButton=driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
		 loginButton.click();
		 try {
		 WebElement clickOnCustomer=driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']"));
		
		 Actions action=new Actions(driver);
		 wait.until(ExpectedConditions.elementToBeClickable(clickOnCustomer));
		 //clickOnCustomer.click();
		
		 action.moveToElement(clickOnCustomer).click().build().perform();
		WebElement clickOnCustomers=driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]"));
		clickOnCustomers.click();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }	// TODO Auto-generated method stub
		 int total_No_Of_Pages = 5; // Set this to the actual number of pages
	        for (int p = 1; p <= total_No_Of_Pages; p++) {
	            if (p > 1) {
	                WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()=" + p + "]"));
	                try {
	                    // Wait until the element is clickable
	                    wait.until(ExpectedConditions.elementToBeClickable(active_page));

	                    // Scroll the element into view
	                    JavascriptExecutor js = (JavascriptExecutor) driver;
	                    js.executeScript("arguments[0].scrollIntoView(true);", active_page);
	                   // Thread.sleep(1000); // Wait for the scrolling to complete

	                    // Click the page number
	                    active_page.click();
	                   // Thread.sleep(3000); // Wait for the page to load
	                } catch (ElementClickInterceptedException e) {
	                    System.out.println("Element click intercepted, trying JavaScript click.");
	                    try {
	                        // Fallback to JavaScript click if the element is blocked by another element
	                        JavascriptExecutor js = (JavascriptExecutor) driver;
	                        js.executeScript("arguments[0].click();", active_page);
	                        Thread.sleep(3000); // Wait for the page to load
	                    } catch (Exception jsException) {
	                        System.out.println("JavaScript click also failed: " + jsException.getMessage());
	                    }
	                } 
	            }

	            // Reading data from the page
	            int total_No_Of_Row_In_Table = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
	            for (int i = 1; i <= total_No_Of_Row_In_Table; i++) {
	                String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]/td[2]")).getText();
	                String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]/td[3]")).getText();
	                String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]/td[5]")).getText();
	                System.out.println(customerName + "\t" + email + "\t" + status);
	            }
	        }

	}

}
