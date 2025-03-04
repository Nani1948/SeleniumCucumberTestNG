package com.seleniumcucumberframework.qa.utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	//Once we got the property filepath, we will open the file inputstream.we have to keep it private for “fileinputstream” 
		//and  private for create an object of “properties “class.They kept at the class level because this should not be used outside of this  property file utility class.
		//others can’t use it.

	   private Properties propFile=null;
	   FileInputStream stream=null;
		public Properties loadFile(String filename) {
			propFile=new Properties();
			
			//To get the path from the constant , we have to create one local variable and name it as properly
			String propertyFilePath=null;
			//Mutiple property from constants.java , we have to use it then so we are using switch case.
			// it will help for future the properties file aslo from constants.java
			
			switch(filename) {
			case "applicationDataProperties":
				propertyFilePath=Constants.APPLICATION_PROPERTIES;
				break;
			 default:
		            System.err.println("Invalid properties file name provided: " + filename);
		            return null;
			}
			//open the propertyFilePath using fileinputstream-FileNotException and propFile.load-IOException the file  with in try tocatch 
			try {
			stream=new FileInputStream(propertyFilePath);
			propFile.load(stream);
			//stream.close();
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			// return the property file and return type is Properties.
			return propFile;
			
		}
		// read the file

		
		public String getProperty(String key) {
			  if (propFile == null) {
		            throw new IllegalStateException("Properties file not loaded. Call loadFile() first.");
		        }
		        return propFile.getProperty(key);
		}
		
		public void writeDataToPropertyFile(File path,String key,String value) {
			if (path == null) {
	            throw new IllegalArgumentException("❌ File path cannot be null.");
	        }
			propFile=new Properties();
			propFile.setProperty(key, value);
			try {
				propFile.store(new FileOutputStream(path), "updating data");
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
}
