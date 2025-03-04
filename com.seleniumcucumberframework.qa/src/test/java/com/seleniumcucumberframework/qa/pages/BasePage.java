package com.seleniumcucumberframework.qa.pages;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumcucumberframework.qa.utilis.Constants;
import com.seleniumcucumberframework.qa.utilis.ExtentReportUtility2;
import com.seleniumcucumberframework.qa.utilis.WaitConstant;




public class BasePage {
	protected static  WebDriver driver;
	protected  WebDriverWait wait;
	protected  Alert alert;
	// Create an objectOf logger
   protected Logger log=LogManager.getLogger(BasePage.class);
   protected ExtentReportUtility2 report=ExtentReportUtility2.getInstance();
	//// Create a constructor of LoginPage for initialization of all web element using the pagefactory.initElement
	// Pass webdriver driver as an object.This object should come from the Automation Script.
	public BasePage(WebDriver driver) {
	     this.driver= driver;
		PageFactory.initElements(driver, this);// it use internally hashmap technique and stores these webelements with corresponding 
	
	}
	
	public String getPageTitle() {
		String titleOfPage=driver.getTitle();
		System.out.println("Title of Page"+titleOfPage );			
		log.info("Title of page :"+titleOfPage);
		return titleOfPage;
		
	}
	public  String getPageSource() {
		String pageofSource=driver.getPageSource();
		System.out.println("Source of page:"+pageofSource);
		log.info("Source of page:"+pageofSource);
		return pageofSource;
	}
	public  void getCurrentURL() {
		String currentURL=driver.getCurrentUrl();
		System.out.println("Current URL:"+currentURL);
		log.info("Current URL:"+currentURL);
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
		log.info("page is refreshed");
	}
	public void navigatedToPreviousPage() {
		driver.navigate().back();
		log.info("it is navigated to previous page");
	}
	public void navigatedToNextPage() {
		driver.navigate().forward();
		log.info("it is navigated to next page");
	}
	//--------------------------Text-------------------------------------------------
	public void enterText(WebElement element,String data,String objectName) {
		if(element.isDisplayed()) {
			 //if (data!= null && !data.isEmpty()) {
			clearElement(element,objectName);
			element.sendKeys(data);
		
			log.info("Pass:"+objectName+ "is entered in the username field");
		  report.logTestInfo(objectName+ "is entered in the username field");
	    //}
		}
		else {
			log.error("Fail:"+objectName+ " element is not displayed");
			report.logTestFail("Fail:"+objectName+ " element is not displayed");
		}
		
		
	}
	public void clearElement(WebElement element,String objectName) {
		if(element.isDisplayed()) {
			element.clear();
			log.info("Pass:"+"Text is cleared in"+objectName);
			//report.logTestInfo("Pass:"+"Text is cleared in"+objectName);
		}
		else {
			log.info("Failed:"+"Text is not cleared in"+objectName);
			//report.logTestInfo("Failed:"+"Text is not cleared in"+objectName);
		}
	}
  
   public  String getText(WebElement element) {
	   try {
	        if (element.isDisplayed()) {
	            String text = element.getText();
	            log.info("Text is printed: " + text);
	            return text;
	        } else {
	        	log.error("Element is not displayed");
	        }
	    } catch (NoSuchElementException e) {
	        log.error("Element not found");
	    } catch (Exception e) {
	    	log.error("An error occurred while retrieving text");
	    }
	    return null;
	}
   public  boolean isTextPresent(WebElement element ,String expectedText) {
	   try {
		   if(element.isDisplayed()) {
			   String actualText=element.getText();
			   System.out.println("Actual text: " + actualText);
	           System.out.println("Expected text: " + expectedText);
	        boolean isPresent=actualText.contains(expectedText);
			if(isPresent) {
				log.info("Text is visble");
			}
			else {
				log.error("Text is not visible");
			}
		   
			return isPresent;
		    } 
	   
	       else {
	    	   log.error("Element is not displayed");
		     }
	   
         } catch (NoSuchElementException e) {
        	 log.error("Element not found");
       } catch (Exception e) {
    	   log.error("An error occurred while checking text presence");
   }
   
   return false;
}
		    
/*   public static boolean waitForTextToBePresent(WebElement element, String expectedText, int timeout) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
	        
	        System.out.println("Expected text is present within the element");
	        return true;
	    } catch (TimeoutException e) {
	        System.out.println("Expected text is not present within the element within the timeout period");
	    } catch (NoSuchElementException e) {
	        System.out.println("Element not found");
	    } catch (Exception e) {
	        System.out.println("An error occurred while waiting for text presence");
	    }
	    
	    return false;
	}	*/   
	public void clickOnLink(String  xpath) {
		WebElement  element=driver.findElement(By.xpath(xpath));
		 element.click();
		 log.info("Click on WebElement link");
	}
	public void isDisplayed(WebElement element) {
		  try {
			   if(element.isDisplayed()) {
				   log.info("Element is displayed");  
			   }  
		       else {
		    	   log.info("Element is not displayed");
			     }
		   
	         } catch (NoSuchElementException e) {
	       System.out.println("Element not found");
	       } catch (Exception e) {
	       System.out.println("An error occurred while checking text presence");
	   }
	   
	
	}
	
		   
	   
   
  //------------------------getAttribute---------------------------
   public String getAttribute(WebElement element, String attributeName) {
	    if (element.isDisplayed()) {
	        String attributeValue = element.getAttribute(attributeName);
	        log.info("Attribute value: " + attributeValue);
	        return attributeValue;
	    } else {
	        log.error("Element is not displayed");
	        return null;
	    }
   }
   //---------------------ClickOnButton---------------------------
   public void clickOnButton(WebElement button) {
	   if (button.isDisplayed()) {
		   button.click();
	log.info("Button is clickable");
    report.logTestInfo("Button is clickable\"");
	   }
	   else {
		  log.error("Button is not clickable");
	   }
   }
   
   public  boolean isButtonPresent(WebElement button) {
	     boolean isDisplayed = button.isDisplayed();
	        
	        if (isDisplayed) {
	            log.info("Button is displayed");
	        } else {
	          log.error("Button is not displayed");
	        }
	        
	        return isDisplayed;
	    } 

   //-------------------------checkbox------------------
   public boolean isChecked(WebElement checkedbox, boolean  notSelectCheckBox) {
	 
	   boolean isCheckedBox=checkedbox.isSelected();
	   
	     if(isCheckedBox!=notSelectCheckBox) {
	    	 checkedbox.click(); 
	     
		   if (notSelectCheckBox) {
	           log.info("checkedbox is selected");
	        } else {
	            log.error("Checkedbox is not selected");
	        }
	     }
		   else {
			   log.error("Checkbox is already in the checked state");
		   }
	        return isCheckedBox;
	   
   }
   //-----------------------------------------------------------Wait--------------
   public void performMouseHoverWithWait(WebDriver driver, WebElement element) {
       // Create an instance of Actions class
       Actions actions = new Actions(driver);

       // Wait for the element to be visible before performing the mouse hover action
       WebDriverWait wait = new WebDriverWait(driver,WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
       wait.until(ExpectedConditions.visibilityOf(element));

       // Perform mouse hover action on the element
       actions.moveToElement(element).build().perform();
       element.click();
       log.info("Waiting for an webelement and Perform click action on the webelement");
   }

   public void waitForPageLoad() {
	   driver.manage().timeouts().pageLoadTimeout(WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
   }
   public void implicitWaitMethod() {
	   driver.manage().timeouts().implicitlyWait(WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
   }
   public  void waitForElementToBeVisible(WebDriver driver, WebElement element,int timeoutInSeconds,String objectName) {
       WebDriverWait wait = new WebDriverWait(driver,WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
       wait.until(ExpectedConditions.visibilityOf(element));
       log.info("waiting for an webelement"+objectName+" for visiblity");
   }
   public  void waitForElementToClickable(WebDriver driver, By locator, int timeoutInSeconds,String objectName) {
       WebDriverWait wait = new WebDriverWait(driver,WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
       wait.until(ExpectedConditions.elementToBeClickable(locator));
       log.info("waiting for an webelement"+objectName+" to be clickable");
   }
   
   public  void waitForTextToBePresent(WebDriver driver, WebElement element,String message, int timeoutInSeconds) {
       WebDriverWait wait = new WebDriverWait(driver,WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
       wait.until(ExpectedConditions.textToBePresentInElement(element, message));
       log.info("waiting for an text to be present");
   }
   public  void   waitUntilAlertIsPresent(WebDriver driver, int timeoutInSeconds) {
       WebDriverWait wait = new WebDriverWait(driver,WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);;
       wait.until(ExpectedConditions.alertIsPresent());
       log.info("waiting for an alert to be present");
   }
   
   
   public void waitForElementToBeInvisible(WebDriver driver, By locator,int timeoutInSeconds,String objectName) {
       WebDriverWait wait = new WebDriverWait(driver,WaitConstant.WAIT_FOR_ELEMENT_TO_LOAD);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
       log.info("waiting for an webelement"+objectName+"for its invisibility");
   }
   public static void waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements, int timeoutInSeconds) {
       Wait<WebDriver> wait = new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(timeoutInSeconds))
               .pollingEvery(Duration.ofMillis(500));

       wait.until(ExpectedConditions.visibilityOfAllElements(elements));
   }
    // Method to wait for the page title to match the expected title
   public static void waitForTitle(WebDriver driver, String expectedTitle) {
       WebDriverWait wait = new WebDriverWait(driver, WaitConstant.WAIT_FOR_TITLE_TO_LOAD);
       wait.until(ExpectedConditions.titleIs(expectedTitle));
   }
   
  
   public  WebElement waitForElementVisibility(WebDriver driver, By locator, int timeoutSeconds,String objectName) {
	    Wait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(timeoutSeconds))
	            .pollingEvery(Duration.ofSeconds(1))
	            .ignoring(NoSuchElementException.class);
	    log.info("waiting for an webelement"+objectName+"for its visibility");
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    
	}
 //or
   /* //-------------------------------WebDriverWait-------------------------------------
   public void waitUntilElementIsVisible(WebElement element,String objectName) {
	   System.out.println("waiting for an webelement"+objectName+"for its visibility");
	   wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   wait.until(ExpectedConditions.visibilityOf(element));
   }
   public void waitUntilPresenceOfElementLocatedBy(By locator,String objectName) {
	   System.out.println("waiting for an webelement"+objectName+"for its visibility");
	   wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   wait.until(ExpectedConditions.presenceOfElementLocated(locator));
   }
   
   public void waitUntilAlertIsPresent() {
	   System.out.println("waiting for alert to be present");
	   wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   wait.until(ExpectedConditions.alertIsPresent());
   }
   public void waitUntilElementToBeClickable(WebElement element,String objectName) {
	   System.out.println("waiting for an webelement"+objectName+"for its visibility");
	   wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   wait.until(ExpectedConditions.elementToBeClickable(element));
   }*/
   
   public void waitUntilPageLoad() {
	   
	   driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	  log.info("waiting until page loads with 30 sec maximum");
   }
  public void waitFluentForVisibility(WebElement element,String objectName){
  Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(2))
		  .ignoring(NoSuchElementException.class);
  
		 wait.until(ExpectedConditions.visibilityOf(element));
		log.info("waiting for an webelement"+objectName+"for its visibility");
  }
  public void waitFluentForFrameToAvaiable(WebElement element,String objectName){
  Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(2))
		  .ignoring(NoSuchElementException.class);
  
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("waiting for an frame"+objectName+"for its visibility");
  }
   
	//----------------------------Frame----------------------------
  
  public void switchToframe(String text) {
	  driver.switchTo().frame(text);
  }
  public void switchToframe(int id) {
	  driver.switchTo().frame(id);
  }
  public void switchToframeByWebElement(WebElement element) {
	  driver.switchTo().frame(element);
  }
  @SuppressWarnings("deprecation")
public void switchToFrameByText(String text) {
	    List<WebElement> frames = driver.findElements(By.tagName("frame"));
	    boolean foundFrame = false;

	    for (WebElement frame : frames) {
	        if (frame.getAttribute("name").equals(text) || frame.getAttribute("id").equals(text)) {
	            driver.switchTo().frame(frame);
	            foundFrame = true;
	            break;
	        }
	    }

	    if (!foundFrame) {
	        log.error("Frame with text '" + text + "' not found");
	    }
	}
//-------------------------------windowhandle---------------------------
  public String getCurrentWindowHandle(WebDriver driver) {
	    return driver.getWindowHandle();
	}
  public Set<String> getAllWindowHandles(WebDriver driver) {
	    return driver.getWindowHandles();
	}
  public void switchToWindow(WebDriver driver, String windowHandle) {
	    driver.switchTo().window(windowHandle);
	}
  public void closeCurrentWindow(WebDriver driver) {
	    driver.close();
	}
  public void switchToDefaultWindow() {
	  driver.switchTo().defaultContent();
  }
  //latest window
  public void switchToNewWindow(WebDriver driver, Set<String> oldWindowHandles) {
	    Set<String> newWindowHandles = driver.getWindowHandles();
	    newWindowHandles.removeAll(oldWindowHandles);
	    String newWindowHandle = newWindowHandles.iterator().next();
	    driver.switchTo().window(newWindowHandle);
	}

   //-------------------------------Action -------------------------------
   public  void moveToElementAction(WebDriver driver,WebElement element,String objectName) {
   Actions action=new Actions(driver);
   action.moveToElement(element).click().build().perform();
   //log.info("cursor moved to WebElement "+objectName);
   log.info("user is a clicked on"+objectName);
   
   }
   public void enterTextOFTextArea(WebDriver driver, WebElement element,String text) {
	     element.click();
	 	 Actions action=new Actions(driver);
	 	 action.sendKeys(text).build().perform();
   }
   public void clickElement(WebDriver driver, WebElement element, String objectName) {
	    Actions action = new Actions(driver);
	    action.moveToElement(element).click().build().perform();
	    log.info("user is a clicked on"+objectName);
	    report.logTestInfo("user is a clicked on"+objectName);
	}
   public  void doubleClickElement(WebDriver driver, WebElement element,String objectName) {
       Actions actions = new Actions(driver);
       actions.doubleClick(element).build().perform();
      log.info("Double click performed on "+objectName);
      report.logTestInfo("Double click performed on "+objectName);
   }
   public  void contextClickElement(WebDriver driver, WebElement element,String objectName) {
       Actions actions = new Actions(driver);
       actions.contextClick(element).build().perform();
       log.info("right click performed on "+objectName);
   }
   public  void dragAndDropElement(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
       Actions actions = new Actions(driver);
       actions.dragAndDrop(sourceElement, targetElement).perform();
      log.info("Drag a file from" +sourceElement+"to" + targetElement);
   }
   //----------------------------------------------Select--------
   
   public void selectByVisibleTextOfElement(WebElement element, String value) {
       Select select = new Select(element);
       select.selectByVisibleText(value);
       log.info("Selected the option by visible text: " + value);
   }
   public void selectByValueOfElement(WebElement element, String value) {
       Select select = new Select(element);
       select.selectByValue(value);
       log.info("Selected the option by value: " + value);
   }
   public  void selectByIndexOfElement(String xpath,int value) {
	   Select select=new Select(driver.findElement(By.xpath(xpath)));
	   select.selectByIndex(value);
	   log.info("select the options by the index");
   }
   public boolean selectOptionByPartialText(WebElement dropdownElement, String partialText) {
	    Select select = new Select(dropdownElement);
	    
	    List<WebElement> options = select.getOptions();
	    for (WebElement option : options) {
	        if (option.getText().contains(partialText)) {
	        	
	            select.selectByVisibleText(option.getText());
	            log.info("Selected the option by visible text: " + partialText);
	    	    report.logTestInfo("Selected the option by visible text:" + partialText);
	            return true;
	        }
	    }
	    log.error("Selected the option by visible text: " + partialText);
	    report.logTestFail("Selected the option by visible text: " + partialText);
	    return false;
	
	}
   public boolean selectOptionByText(WebElement dropdownElement, String text) {
	    Select select = new Select(dropdownElement);
	    
	    List<WebElement> options = select.getOptions();
	    for (WebElement option : options) {
	        if (option.getText().contains(text)) {
	        	select.deselectByVisibleText(option.getText());
	        	log.info("Deselected the option by visible text: " + text);
	    	    report.logTestInfo("Selected the option by visible text:" + text);
	            select.selectByVisibleText(option.getText());
	            log.info("Selected the option by visible text: " + text);
	    	    report.logTestInfo("Selected the option by visible text:" + text);
	            return true;
	        }
	    }
	    log.error("Selected the option by visible text: " + text);
	    report.logTestFail("Selected the option by visible text: " +text);
	    return false;
	
	}
   public boolean isOptionSelectedInDropdown(WebElement dropdownElement, String optionText) {
	    Select select = new Select(dropdownElement);
	    List<WebElement> selectedOptions = select.getAllSelectedOptions();
	    for (WebElement option : selectedOptions) {
	        if (option.getText().equals(optionText)) {
	            return true;
	        }
	    }
	    return false;
	}
   public void removeOptionFromDropdown(WebElement dropdownElement, String optionText) {
	    Select select = new Select(dropdownElement);
	    select.deselectByVisibleText(optionText);
	}
   public void addOptionToDropdown(WebElement dropdownElement, String optionText) {
	    Select select = new Select(dropdownElement);
	    select.selectByVisibleText(optionText);
	}
  // ----------------------------Alert-----------------------------------------
public Alert switchToAlert() {
	Alert alert = driver.switchTo().alert();
	log.info("switched To Alert");
	return alert;
}
  
  public void acceptAlert(Alert alert) {
	
	    alert.accept();
	    log.info("Alert is accepted");
	  
	}
  public void dismissAlert(Alert alert) {
	
	    alert.dismiss();
	    log.info("Alert is dismiss");
	}
  public String getAlertText(Alert alert) {
	 log.info("Extract text in the alert");
	    return alert.getText();
	}
  public void enterTextInAlertPrompt(Alert alert,String text) {
	   
	    alert.sendKeys(text);
	    log.info("Enter the text in the alert box");
	    alert.accept();
	    log.info("alert is accepted");
	}
  
  //----------------------------RadioButton---------------------------------
  public void selectRadioButton(WebElement element,String text) {
      
        if (!element.isSelected()) {
            element.click();
            log.info("Selected the radio button with element " + text);   
        }
    }

    public void deselectRadioButton(WebElement element,String text) {
       
        if (element.isSelected()) {
        	element.click();
            log.info("Deselected the radio button with element: " +  text);
        }
    }
  //-------------------------List WebElement-------------
  public WebElement findElementByText(List<WebElement> elements, String targetText) {
	    for (WebElement element : elements) {
	        if (element.getText().equals(targetText)) {
	            return element;
	        }
	    }
	    return null; // Return null if the element is not found
	}
  
  
  //-------------------------------screenshot-------------------------------
 
  
  public WebDriver returnDriverInstance() {
	  return driver;
  }
 
}
