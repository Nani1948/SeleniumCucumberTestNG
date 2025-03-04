package com.seleniumcucumberframework.qa.datepicker;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerOFJQueryINputbox {
	public static void selectFutureMonthandYear(WebDriver driver,String month,String year){
		while (true) {
	        // Get the current year and month from the datepicker
	        String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	        String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	        
	        // Check if current month and year match the desired month and year
	        if (currentMonth.equals(month) && currentYear.equals(year)) {
	            break;
	        }
	        
	        // Click on the "next" button to go to the next month
	        WebElement element = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
	        element.click();
	        
	        // Wait for the next month to load (optional, depending on your system's speed)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-datepicker-month']")));
	    }
		
	}

	public 	static void selectFutureDate(WebDriver driver,String date){

		 // Get all the date elements inside the calendar
	    List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	    
	    // Iterate through the date elements
	    for (WebElement dates : allDates) {
	        // Check if the date text matches the one you're looking for
	        if (dates.getText().equals(date)) {
	            // Click the matching date
	            dates.click();
	            break;
	        }
	    }

		}
	public static void selectPreviousMonthandYear(WebDriver driver,String month,String year){
		  while(true) {
		        String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		        String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		        if(currentMonth.equals(month) && currentYear.equals(year)) {
		        	break;
		        }
		        WebElement element=driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[1]/span"));
		        element.click();
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[1]/span")));
		  }
	}

	public 	static void selectPreviousDate(WebDriver driver,String date){

		  //Find the date
        List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement dates:allDates) {
        	if(dates.getText().equals(date)) {
        		
        		dates.click();
        		break;
        	}
        	
        
		}

		}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		//Method1:
		WebElement iframe=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
      /*  WebElement date= driver.findElement(By.xpath("//input[@id='datepicker']"));
        //date.click();
        date.sendKeys("12/12/2025");
        driver.switchTo().defaultContent();*/
        
        //Method2:Future Year
       /* String year="2025";
        String month="May";
        String date="20";
        WebElement datePicker= driver.findElement(By.xpath("//input[@id='datepicker']"));
  
        datePicker.click();
       // DatePickerOFJQueryINputbox.selectFutureMonthandYear(driver, month, year);
        //DatePickerOFJQueryINputbox.selectFutureDate(driver, date);
        
        /*Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");*/
     
        //Previuos
         String year1="2022";
        String month1="May";
        String date1="20";

        /*Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");*/
        WebElement datePicker= driver.findElement(By.xpath("//input[@id='datepicker']"));
        
        datePicker.click();
        DatePickerOFJQueryINputbox.selectPreviousMonthandYear(driver, month1, year1);
        DatePickerOFJQueryINputbox.selectPreviousDate(driver, date1);
        
      
        }
	}


