package com.seleniumcucumberframework.qa.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "@target/failedrerun_scenarios.txt",  // Rerun only failed scenarios
	    glue = "com.seleniumcucumberframework.qa.stepdefinitions",
	    plugin = {
	        "pretty", 
	        "html:target/cucumber-reports-rerun.html",
	        "rerun:target/failedrerun_scenarios.txt"
	    },
	    monochrome = true
	)
	public class FailedTestRunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = false)  // Allows parameterized execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}