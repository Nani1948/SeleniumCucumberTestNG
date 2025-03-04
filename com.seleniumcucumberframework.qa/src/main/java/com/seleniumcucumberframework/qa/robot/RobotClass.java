package com.seleniumcucumberframework.qa.robot;

import java.awt.AWTException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotClass {

	public static void main(String[] args) throws AWTException,InterruptedException {
		//Robot class: it is a need to control the keyboard or mouse to interact with os windows like download popup,alerts,print pop-ups etc...
		//Selenium WebDriver cant handle these os pop-ups/applications.
		//Robot class can simutlate keyboard and mouse events .
		//Robot class can help in upload/Downloads of files whe  useing selenium.
		//Robot class can easily be integrated with current automation framework(keyword, data-driven or hybrid)
		//To press tab:rotot.keyPress(KeyEvent.VK_TAB);
		//To Press down arraow: rotbot.keyPress(KeyEvent.VK_Down)
		//To Press Enter key we use: robot.keyPress(KeyEvent.VK_Enter);
	
			WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://demoqa.com/upload-download");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		 
		  WebElement downloads=driver.findElement(By.xpath("//a[@id='downloadButton']"));
		   downloads.click();
		  
		  /* Robot robot=new Robot();
		// Get the location and size of the element
	        Point location = downloads.getLocation();
	        Dimension size = downloads.getSize();
	        int x = location.getX() + size.getWidth() / 2;
	        int y = location.getY() + size.getHeight() / 2;
	        //Move the mouse to the center of the element and perform the click
	        robot.mouseMove(x, y);
	        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);  // Press left mouse button
	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);*/
		  Robot robot=new Robot();
		  //String downloadsDirectory="C:\\Users\\knand\\Downloads";
		     // Press Enter to open the Downloads folder
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
		  
		// Simulate opening the file explorer (Windows + R)
	        robot.keyPress(KeyEvent.VK_WINDOWS);
	        robot.keyRelease(KeyEvent.VK_WINDOWS);
	        robot.keyPress(KeyEvent.VK_R);
	        robot.keyRelease(KeyEvent.VK_R);

	        // Pause to ensure the 'Run' dialog is open
	        //Thread.sleep(1000);

	        // Type the path to the Downloads folder (example path for Windows)
	        /*for (char c : downloadsDirectory.toCharArray()) {
	            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
	            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
	        }*/

	   

	        // Step 7: Wait for the folder to open
	      //  Thread.sleep(2000);  // Wait for the folder to open (adjust timing as needed)

	        // Step 8: Navigate to the downloaded file (use arrow keys)
	        // Assuming file is at the top of the list, simulate the key press
	       /* for (int i = 0; i < 5; i++) { // Change the number based on file position
	            robot.keyPress(KeyEvent.VK_DOWN);
	            robot.keyRelease(KeyEvent.VK_DOWN);
	            Thread.sleep(500);  // Adjust for file location in the list
	        }*/
	        

	        // Step 9: Simulate double-click (left mouse click) on the file
	        robot.mouseMove(500, 500); // Adjust x, y coordinates based on the file's position on screen
	        robot.mousePress(KeyEvent.);  // Left click
	        robot.mouseRelease(KeyEvent.BUTTON1_MASK);

	        // Step 10: Press Enter to open the file
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	

}
