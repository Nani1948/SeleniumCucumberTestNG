package com.seleniumcucumberframework.qa.alert;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatePopupORAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  //if you want inject username and password along with url
		  //Syntax:http://username:password@the-internet.herokuapp.com/basic_auth
		  driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		 
          
	}

}
