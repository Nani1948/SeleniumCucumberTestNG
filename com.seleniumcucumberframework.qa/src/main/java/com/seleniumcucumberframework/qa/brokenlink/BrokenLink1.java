package com.seleniumcucumberframework.qa.brokenlink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.get("http://www.deadlinkcity.com/");
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  //1.Identify  all the linkson the webpage
		  List<WebElement> links=driver.findElements(By.tagName("a"));
		  //iterative over each links
		  for(WebElement link:links) {
			@SuppressWarnings("deprecation")
			String url =link.getAttribute("href");
			if(url!=null && !url.isEmpty()) {
				checkBrokenLink(url);
			}
		  }
		  
	}

	public  static void checkBrokenLink(String url) {
	try {
		HttpURLConnection httpUrlConnect=(HttpURLConnection)new URL(url).openConnection();
		 httpUrlConnect.setRequestMethod("HEAD");
		 httpUrlConnect.connect();
		 int responseCode= httpUrlConnect.getResponseCode();
		 if(responseCode >=400) {
			 System.out.println("Broken Link:"+ url +",Response Code:"+responseCode);
		 }
		 else {
			 System.out.println("Valid  Link:"+ url +",Response Code:"+responseCode);
		 }
	}
	catch(Exception e) {
		System.out.println("Error with Link: " + url + " Exception: " + e.getMessage());
	}
		
	}
}
