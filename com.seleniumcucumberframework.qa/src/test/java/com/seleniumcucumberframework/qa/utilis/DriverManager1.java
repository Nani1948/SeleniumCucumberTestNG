package com.seleniumcucumberframework.qa.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*public class DriverManager1 {



	
		// private static WebDriver driver;
		 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
		  // Factory Method to get WebDriver instance
		    public static WebDriver getDriver(String browserName, boolean isHeadless) {
		        if (driver.get() == null) {
		            driver.set(createDriver(browserName, isHeadless));
		        }
		        return driver.get();
		    }
		 private static WebDriver createDriver(String browserName, boolean isHeadless) {
		        WebDriver driver = null;
		        System.out.println("Creating driver for browser: " + browserName + " with headless mode: " + isHeadless);
		        switch (browserName.toLowerCase()) {
		            case "chrome":
		            	WebDriverManager.chromedriver().setup();
		            	  ChromeOptions chromeOptions = new ChromeOptions();
		                  if (isHeadless) {
		                      chromeOptions.addArguments("--headless", "--disable-gpu");
		                  }
		                driver = new ChromeDriver(chromeOptions);
		                break;
		            case "safari":
		            	WebDriverManager.safaridriver().setup();
		                driver = new SafariDriver();// Safari doesn't support headless mode
		                break;
		            case "edge":
		            	WebDriverManager.edgedriver().setup();
		            	EdgeOptions edgeOptions = new EdgeOptions();
		                if (isHeadless) {
		                    edgeOptions.addArguments("--headless");
		                }else {
		                    System.out.println("ChromeOptions: Headless mode disabled.");
		                }
		                driver = new EdgeDriver(edgeOptions);	              
		                break;
		                
		            default:
		                System.out.println("WebDriverManager: getBrowserType: Unsupported browser name: " + browserName);
		                break;
		        }
		        if (driver != null) {
		            configureDriver(driver);
		        }
		        return driver;
		    }
		 // Configure driver settings (timeouts, window size, etc.)
		    private static void configureDriver(WebDriver driver) {
		        driver.manage().timeouts().pageLoadTimeout(WaitConstant.PAGELOAD_WAIT_TIME);
		        driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_TIME);
		        driver.manage().window().maximize();
		        driver.manage().deleteAllCookies();
		        System.out.println("WebDriverManager: configureDriver: Driver configured");
		    }
		 // Close the driver (useful for cleanup in tests)
		    public static void quitDriver() {
		        if (driver.get() != null) {
		            driver.get().quit();
		            driver.remove();
		            System.out.println("WebDriver quit and cleaned up");
		        }
		    }
		    public WebDriver getDriver() {
		        return driver.get();
		    }
		    *
		    @BeforeSuite
		    public void setup() {
		        logger.debug("DriverManager: setup: configuration started");
		        extent = new ExtentReports();
		        ExtentSparkReporter report = new ExtentSparkReporter(new File(Constants.SPARK_HTML_REPORT_PATH));
		        extent.attachReporter(report);
		        logger.debug("DriverManager: setup: configuration complete");
		    }

		    @AfterSuite
		    public void tearDown() {
		        if (extent != null) {
		            extent.flush();
		        }
		        logger.debug("DriverManager: tearDown: completed");
		    }
		    @Before
		    public void setUpDriver(Scenario scenario) {
		        logger.debug("DriverHook: setUpDriver: Hook started for scenario: " + scenario.getName());
		        
		        // Load properties
		        PropertiesUtility prop = new PropertiesUtility();
		        Properties applicationPro = prop.loadFile("data.properties");
		        
		        // Get browser type and initialize driver
		        String browserName = applicationPro.getProperty("browser");
		        boolean isHeadless = Boolean.parseBoolean(applicationPro.getProperty("isHeadless", "false"));
		        
		        // Initialize WebDriver
		        driver = DriverManager.initializeDriver(browserName, isHeadless);
		        
		        // Set the driver to ThreadLocal
		        threadLocalDriver.set(driver);
		        
		        // You can also create ExtentTest here if needed
		        // Create ExtentTest instance for the current scenario
		        ExtentTest test = extent.createTest(scenario.getName()); // Assuming ExtentManager class exists for report handling
		       extent.;

		        logger.debug("DriverHook: setUpDriver: WebDriver initialized and ExtentTest configured");
		    }
		/*
		    @Parameters({"browserName", "isHeadless"})
		    @BeforeMethod
		    public void setUpDriver(@Optional("chrome") String browserName, @Optional("false") boolean isHeadless, Method method) {
		        PropertiesUtliyClass prop = new PropertiesUtliyClass();
		        Properties applicationPro = prop.loadFile("data.properties");

		        // Get browser type and initialize driver
		        driver = initializeDriver(applicationPro.getProperty("browser"), isHeadless);
		        
		        // Set the driver to ThreadLocal
		        threadLocalDriver.set(driver);
		        
		        // Create ExtentTest instance for the current method
		        ExtentTest test = extent.createTest(method.getName());
		        threadExtentTest.set(test);

		        logger.debug("DriverManager: setUpDriver: driver and test configuration complete");
		    }*/

		  /*  @AfterMethod
		    public void removeDriver() {
		        if (threadLocalDriver.get() != null) {
		            threadLocalDriver.get().quit();
		            threadLocalDriver.remove();
		            logger.debug("DriverManager: removeDriver: WebDriver quit and cleaned up for thread");
		        }
		    }

		    public static WebDriver getDriver() {
		        return threadLocalDriver.get();
		    }

		    public static ExtentTest getTest() {
		        return threadExtentTest.get();
		    }
		    public static void setTest(ExtentTest test) {
		        threadExtentTest.set(test);
		    }
		    private static WebDriver initializeDriver(String browserName, boolean isHeadless) {
		        WebDriver driver = null;
		        logger.debug("DriverManager: initializeDriver: initializing driver for browser: " + browserName + " with headless mode: " + isHeadless);
		        browserName = browserName.toLowerCase();

		        switch (browserName) {
		            case "chrome":
		                ChromeOptions chromeOptions = new ChromeOptions();
		                if (isHeadless) {
		                    chromeOptions.addArguments("--headless", "--disable-gpu");
		                }
		                driver = new ChromeDriver(chromeOptions);
		                break;

		            case "safari":
		                driver = new SafariDriver();
		                break;

		            case "edge":
		                driver = new EdgeDriver();
		                break;

		            case "ie":
		                driver = new InternetExplorerDriver();
		                break;

		            default:
		                logger.error("DriverManager: initializeDriver: Unsupported browser: " + browserName);
		                break;
		        }

		        if (driver != null) {
		            driver.manage().timeouts().pageLoadTimeout(WaitConstant.PAGELOAD_WAIT_TIME);
		            driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_TIME);
		            driver.manage().window().maximize();
		            driver.manage().deleteAllCookies();
		            logger.debug("DriverManager: initializeDriver: " + browserName + " driver configured");
		        }

		        return driver;
		    }
			   /* public WebDriver getDriver() {
			        return driver; }*/

	

