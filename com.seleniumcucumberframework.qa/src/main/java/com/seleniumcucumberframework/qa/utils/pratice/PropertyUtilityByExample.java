package com.seleniumcucumberframework.qa.utils.pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilityByExample {
	private FileInputStream fis=null;
	private Properties propFile=null;
    public Properties loadFile(String fileName) {
    	propFile=new Properties();
    	String propFilePath=null;
    	switch(fileName) {
    	case "applicationDataProperties":
    		propFilePath=Constants.APPLICATION_DATA_PROPERTIES;
    	case "disputeDataProperties":
    		propFilePath=Constants.DISPUTE_DATA_PROPERTIES;
    	}
    	try {
    		fis=new FileInputStream(propFilePath);
    		propFile.load(fis);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	
      return propFile;
    }
    public String getProperties(String key) {
    	String value=propFile.getProperty(key);
    	System.out.println("Property we got from the file is:"+value);
    	try {
    		fis.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	return value;
    }
}
