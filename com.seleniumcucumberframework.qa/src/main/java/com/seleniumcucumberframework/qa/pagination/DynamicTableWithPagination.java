package com.seleniumcucumberframework.qa.pagination;

import java.time.Duration;
import java.util.List;

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

public class DynamicTableWithPagination {
public static void main(String[]args) {
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
	 }
	 
	 //How to capture the no.of.pages
	 //start index-start with 0 
	 //end index-start with 1-count the no.of.charcter
	WebElement captureTitleOfString=driver.findElement(By.xpath("//div[contains(text(),'Pages')]"));
	String titleOfText=captureTitleOfString.getText();
    int  total_pages=Integer.parseInt(titleOfText.substring(titleOfText.indexOf("(")+1, titleOfText.indexOf("Pages")-1));
    System.out.println("Total_No_Of_Pages:"+ total_pages);
    //repeating pages
    //p-pages start with index 1, no need to click ,
    for(int p=1;p<=5;p++) {
    	if(p>1) { // Skip the first page
    	 WebElement pageButton=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+ p +"]"));
    	  try {
    		 // // Scroll the page button into view
    		  JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("arguments[0].scrollIntoView(true);",  pageButton);
              pageButton.click();// Click the pagination button
              wait.until(ExpectedConditions.stalenessOf(pageButton)); 
          } /*catch (ElementClickInterceptedException e) {
              System.out.println("Element is blocked by another element. Trying JavaScript click.");
              
              // Use JavaScriptExecutor to click the element if normal click is blocked
              /*JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("arguments[0].click();", active_page);*/
              /*
           }*/ 
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	}
    	
    	
    		
    	
    	//reading data from the page
    /*int total_No_Of_Row_In_Table=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]")).size();
     for(int i=1;i<=total_No_Of_Row_In_Table;i++) {
    	 String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]/td[2]")).getText();
    	 String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]/td[3]")).getText();
    	 String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]/td[5]")).getText();
    	 System.out.println(customerName+"\t"+email+"\t"+status);*/
    	    // Wait for the table rows to be visible (after page load or pagination)
         

          // Scrape data from the table
          List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
          for (WebElement row : rows) {
              String customerName = row.findElement(By.xpath(".//td[2]")).getText();
              String email = row.findElement(By.xpath(".//td[3]")).getText();
              String status = row.findElement(By.xpath(".//td[5]")).getText();
              System.out.println(customerName + "\t" + email + "\t" + status);
          }
      }

} 
   
    	 
    
	
	 
}

