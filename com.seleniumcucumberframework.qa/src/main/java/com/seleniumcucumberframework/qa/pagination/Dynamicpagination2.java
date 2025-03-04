package com.seleniumcucumberframework.qa.pagination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamicpagination2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		int total_Pages=4;
		for(int p=1;p<=total_Pages;p++) {
			if(p>1) {
				// 
				WebElement pageButton=driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='"+p+"']"));
				pageButton.click();
			}
			System.out.println("Pages:"+p);
		//identify The row no.of.row
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='productTable']//tbody//tr")));
		 int totalNoOfRow=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		for(int r=1;r<=totalNoOfRow;r++) {
			String id=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[1]")).getText();
			String name=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
			String price=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]")).getText();
			WebElement selected=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[4]//input[@type='checkbox']"));
			if(selected.isDisplayed()) {
				 wait.until(ExpectedConditions.visibilityOf(selected));	
				 if (!selected.isSelected()) {
					 selected.click();  // Click to check the checkbox
			        }
			}
			boolean select=selected.isSelected();
			
			System.out.println(id+","+name+","+price+","+select);
		}
	}
		}}

