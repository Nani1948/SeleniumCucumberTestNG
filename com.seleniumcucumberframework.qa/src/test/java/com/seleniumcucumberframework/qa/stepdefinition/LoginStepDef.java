package com.seleniumcucumberframework.qa.stepdefinition;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.seleniumcucumberframework.qa.pages.HomePage;
import com.seleniumcucumberframework.qa.pages.LoginPage;
import com.seleniumcucumberframework.qa.utilis.DriverManagerFactory;
import com.seleniumcucumberframework.qa.utilis.Log4JUtility;
import com.seleniumcucumberframework.qa.utilis.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginStepDef {
	
	WebDriver driver = DriverManagerFactory.getDriver(); 
    private static final Logger log =  Log4JUtility.getInstance().getLogger();
    LoginPage login;
    HomePage home;
    protected PropertiesUtility prop=new PropertiesUtility();
    protected Properties applicationPro=prop.loadFile("applicationDataProperties");

    public LoginStepDef() {
       // this.driver = ScenarioContext.getDriver(); // Fetch from shared storage
        login = new LoginPage(driver);
        home = new HomePage(driver);
    }

   public void goToUrl(String url) {
       driver.get(url);
       log.info(url + " is entered");
   }


   @Given("User open salesforce application")
   public void userOpensSalesforceApplication() {
	 String url2 = applicationPro.getProperty("url1");
     goToUrl(url2);
    
}
   @Given("User is on the {string}")
   public WebDriver userIsOnLoginPage(String page) {
	switch (page.toLowerCase()) {
    case "loginpage":
        login = new LoginPage(driver);
        home = null; // Set home to null when on the login page
        break;
    case "homepage":
        login = null; // Set login to null when on the homepage
        home = new HomePage(driver);
        break;
     
        
    default:
        throw new IllegalArgumentException("Invalid page: " + page);
}
return driver;
}
   
   @When("User enters username as {string}")
   public void userEntersUsername(String username1) {
	   username1=applicationPro.getProperty("valid_username");
	
    login.enterUsername(username1);
}
  /*@And("User enters password as {password1}")
   public void userEnterPassword(String password1) {
	  login.enterPassword(applicationPro.getProperty("valid_password"));
  }*/
  
  @And("User clears the password field")
  public void userClearsPasswordField() {
	 
     login.clearPassword(applicationPro.getProperty("password"));
}
  @When ("User enters password as {string}")
   public void userEnterPassword(String password1) {
	  password1=applicationPro.getProperty("valid_password");
	  login.enterPassword(password1);
  }
  @When("User clicks on the Login button")
  public void userClicksOnLoginButton() {
	login.clickOnLoginButton();
}
  @Then("The error message should be displayed")
  public void theErrorMessageShouldBeDisplayed() {

    String actualErrorMessage= login.getErrorMessageOnLoginPage();
    String exceptedErrorMessage=applicationPro.getProperty("error_Message_for_valid_username_and_No_Password");
    Assert.assertEquals(actualErrorMessage,   exceptedErrorMessage);
}

  @Then("The home page should be displayed")
  
  public void loginIntoHomePage() {
	  String exceptedHomePageTitle=applicationPro.getProperty("title_of_Home_Page");
	  String actualHomePageTitle=home.getTitleOfPage(exceptedHomePageTitle);
	  Assert.assertEquals(actualHomePageTitle,   exceptedHomePageTitle);
  }
  


   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  
  


}
