package com.seleniumcucumberframework.qa.utilis;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JUtility {
	  // Logger instance
    private Logger log = null;
    
    // Singleton instance of Log4JUtility
    private static volatile Log4JUtility instance = null;

    // Private constructor to prevent instantiation
    private Log4JUtility() {
    }

    // Singleton method to get the instance
    public static Log4JUtility getInstance() {
        if (instance == null) {
            synchronized (Log4JUtility.class) {
                if (instance == null) {
                    instance = new Log4JUtility();
                }
            }
        }
        return instance;
    }

    // Method to get the Logger
    public Logger getLogger() {
        if (log == null) {
            // Lazy initialization of logger
            log = LogManager.getLogger(Log4JUtility.class);
        }
        return log;
    }
}
