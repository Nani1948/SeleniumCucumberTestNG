package com.seleniumcucumberframework.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(id="username")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="Login")WebElement loginButton;
	@FindBy(xpath="//label[contains(text(),'Remember me')] ")WebElement  rememberMe;
	@FindBy(xpath="//span[@id='idcard-identity']")WebElement  textOfUsername;
	@FindBy(xpath="//div[@id='error']")WebElement     textOfErrorMessage;
	@FindBy(xpath="//a[contains(text(),'Forgot Your Password?')]")WebElement forgotPasswordlink;
	public LoginPage(WebDriver driver){
		super(driver);// it will call the super class constructor;when to call super constuructor it will intialize the webelement and this refer to the current object of LoginPage.
	}
	
	public void enterUsername(String usernameData) {
		clearElement(username, "Username field");
		enterText(username, usernameData, "Username field");
	}
	
	public void enterPassword(String passwordData) {
		clearElement(password, "Password  field");
		enterText(password, passwordData, "Password field");
	}
	public void clearPassword(String passwordData) {
		clearElement(password, "Password  field");
		
	}
	public void clickOnLoginButton() {
		clickElement(driver, loginButton,"Login Button");
	}
	
	public void checkRememberMe() {
		isChecked( rememberMe, true);
	}
	

	public String getTextOfUsername() {
		return getText(textOfUsername);
	}
	
	public String getTitleOfThePage() {
		return getPageTitle();
	}
	
	public String getErrorMessageOnLoginPage() {
		   return getText(textOfErrorMessage);
	   }
	public void  clickOnForgotPassword() {
		moveToElementAction(driver,forgotPasswordlink,"Forgot Password Link");
	}
	public  void enterUrl(String url) {
			/* if (driver != null) {
			        log.info("Navigating to URL: " + url);
			        driver=getDriver();
			        driver.get(url);
			    } else {
			        log.error("WebDriver is not initialized!");
			    }*/
		 if (driver == null) {
		        log.error("WebDriver is not initialized! Cannot navigate.");
		    } else {
		        log.info("Navigating to URL: " + url);
		        driver.get(url);  // Just navigate without re-initializing driver
		    }
		}
		
	}
