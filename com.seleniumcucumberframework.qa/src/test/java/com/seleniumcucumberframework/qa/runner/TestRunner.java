package com.seleniumcucumberframework.qa.runner;
import com.seleniumcucumberframework.qa.utilis.TestEventListenerUtility;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(com.seleniumcucumberframework.qa.utilis.TestEventListenerUtility.class)
@CucumberOptions(features="src/test/resources/features/login.feature",
                 glue="com/seleniumcucumberframework/qa/stepdefinition",
                
                 plugin= {"pretty", "html:target/cucumber-reports/cucumber1.html",
                	        "json:target/cucumber-reports/cucumber1.json",
                	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                	        "rerun:target/failedrerun_scenarios.txt"},
                 monochrome = true,
                 dryRun = false

    )
public class TestRunner extends AbstractTestNGCucumberTests {
	/*private static final Logger logger = (Logger) LogManager.getLogger("DriverManager");
    private static WebDriver driver=null;
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<>();
    private static ExtentReports extent = null;
	  @BeforeSuite
	    public void setup() {
	    	 logger.debug("DriverManager: setup: configuration started");

	    	    if (extent == null) {
	    	        extent = new ExtentReports();
	    	        ExtentHtmlReporter report = new ExtentHtmlReporter(new File(Constants.SPARK_HTML_REPORT_PATH));
	    	        extent.attachReporter(report);
	    	        logger.debug("ExtentReports initialized successfully.");
	    	    } else {
	    	        logger.debug("ExtentReports already initialized.");
	    	    }

	    	    logger.debug("DriverManager: setup: configuration complete");
	    }

	    @AfterSuite
	    public void tearDown() {
	        if (extent != null) {
	            extent.flush();
	        }
	        logger.debug("DriverManager: tearDown: completed");
	    }*/
	@Override
    @DataProvider(parallel = false)  // Allows parameterized execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
