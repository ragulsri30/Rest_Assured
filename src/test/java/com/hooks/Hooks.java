package com.hooks;
import org.apache.log4j.Logger;
import org.bouncycastle.asn1.ocsp.Request;

import com.Runner.Runner;
import com.Steps.StepDefinition;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.endpoints.Endpoint;
import com.extents.Extent;
import com.helper.Helpers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class Hooks extends Helpers {
	

	public static ExtentTest test;
	public static ExtentReports extentReports;
	 private static final Logger logger = Logger.getLogger(Runner.class);
	@Before(order = 1)
    public void setUp(Scenario scenario) {
        extentReports = Extent.getExtentReports();
        test = extentReports.createTest(scenario.getName()); // Create a test with the scenario name
    }
    
    @After(order = 1)
    public void tearDown(Scenario scenario) {
    	
    	
    	
    	
    	 // Sample request and response logging
        String request = Endpoint.post_body;
        String response = res.asPrettyString();

        // Log request and response
        logger.info("Request: " + request);
        logger.info("Response: " + response);

        // Log the request and response in the Extent Report
        test.log(Status.INFO, "Request: " + request);
        test.log(Status.INFO, "Response: " + response);

    	
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Test Case Failed"); // Log test as failed if scenario fails
        } else {
            test.log(Status.PASS, "Test Case Passed"); // Log test as passed if scenario passes
        }
    }
    
    @After(order = 0)
    public void flushReport() {
    	extentReports.flush(); // Generate the Extent Report after all scenarios
    }
	


	/*
	 * 
	 * 
	 * @After public static void mai() { // Initialize Extent Report
	 * ExtentHtmlReporter htmlReporter = new
	 * ExtentHtmlReporter("extent-report.html"); extentReports = new
	 * ExtentReports(); extentReports.attachReporter(htmlReporter);
	 * 
	 * // Create a test in Extent Report test = extentReports.createTest("My Test",
	 * "Description of my test");
	 * 
	 * // Sample request and response logging String request = Endpoint.post_body;
	 * String response = res.asPrettyString();
	 * 
	 * // Log request and response logger.info("Request: " + request);
	 * logger.info("Response: " + response);
	 * 
	 * // Log the request and response in the Extent Report test.log(Status.INFO,
	 * "Request: " + request); test.log(Status.INFO, "Response: " + response);
	 * 
	 * // Mark the test as passed in the Extent Report test.pass("Test passed");
	 * 
	 * // Flush the Extent Report extentReports.flush(); }
	 */
	

}
