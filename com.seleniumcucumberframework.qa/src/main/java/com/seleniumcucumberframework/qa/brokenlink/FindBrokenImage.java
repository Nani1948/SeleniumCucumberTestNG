package com.seleniumcucumberframework.qa.brokenlink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenImage {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("https://demoqa.com/broken");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  //1.Identify  all the linkson the webpage
		  List<WebElement> images=driver.findElements(By.tagName("img"));
		  System.out.println("Total number of Images on the Page are " + images.size());
	        
	        
	        //checking the links fetched.
	        for(int index=0;index<images.size();index++)
	        {
	            WebElement image= images.get(index);
	            @SuppressWarnings("deprecation")
				String imageURL= image.getAttribute("src");
	            System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
	            verifyLinks(imageURL);
	          
	            //Validate image display using JavaScript executor
	            try {
	                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
	                if (imageDisplayed) {
	                    System.out.println("DISPLAY - OK");
	                }else {
	                     System.out.println("DISPLAY - BROKEN");
	                }
	            } 
	            catch (Exception e) {
	            	System.out.println("Error Occured");
	            
	        }
	        }
	        
	}    
	   
	    
	    public static void verifyLinks(String linkUrl)
	    {
	        try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	            if(httpURLConnect.getResponseCode()>=400)
	            {
	            	System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
	            }
	        }catch (Exception e) {
	      }
	   }
	    
	 }

