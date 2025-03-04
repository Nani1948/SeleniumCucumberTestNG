package com.seleniumcucumberframework.qa.tooltip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicToolTip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//1 Identify the element of tooltip that trigger.
		WebElement triggedToolTip=driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		Actions action=new Actions(driver);
		action.moveToElement(triggedToolTip).click().build().perform();
		/*WebElement toolTipTextVisible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@aria-describedby,'buttonToolTip')]")));
		
        String  toolTipText=toolTipTextVisible.getText();
        System.out.println(toolTipText);
        String  actualToolTipText="You hovered over the Button";
        if(toolTipText.equals(actualToolTipText)) {
        	System.out.println("Both are equal");
        }
        else {
        	System.out.println("Both are not equal");
        }*/
		  WebElement toolTip = driver.findElement(By.className("tooltip-inner"));

          // Ensure tooltip is visible using JavaScript
          Boolean isVisible = (Boolean) js.executeScript("return arguments[0].offsetParent !== null;", toolTip);

          if (isVisible) {
              // Capture and print tooltip text
              String tooltipText = (String) js.executeScript("return arguments[0].textContent;", toolTip);
              System.out.println("Tooltip Text (Visible): " + tooltipText);
          } else {
              System.out.println("Tooltip is not visible.");
          }
	}

}
