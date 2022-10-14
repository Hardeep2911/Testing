package com.inetBanking.utillities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.testCases.Base;

public class Reporting extends Base implements ITestListener{
	
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	//ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	//ThreadLocal is a class responsible to make our execution thread safe
	
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYYhhmmss");
		String reportname =sdf.format(d)+".html";
		String path = System.getProperty("user.dir")+"\\reports\\"+"Test-report"+reportname;
		reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Report");//title of report
		reporter.config().setReportName("Automation Results");//name of report
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Hardeep");
		extent.setSystemInfo("Environment", "QA");
		
		//test = extent.createTest(result.getName());
		//create a new entry in the report
		//and will get the method name, earlier we put the name directly because we were
		//inside the method
		//we are using the same test object to report the pass or fail, so one object would
		//override another
		//extentTest.set(test);
		//extentTest will store all our test objects
		//above step is sending all the Test objects created into the ThreadLocal pool'
		
	
	}
	
	//Itestresult is a class with result as object, 
	//result will have the status of the every test method

	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		//test.log(Status.PASS, "THE PASSED TEST CASE IS "+result.getName());
		//replacing test with extentTest.get(), it will get the test object from the
		//pool for the particular method as it has the knowledge
		test.log(Status.PASS, "THE PASSED TEST CASE IS "+result.getName());
			
	}


	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "THE FAILED TEST CASE IS "+result.getName());
		test.log(Status.FAIL, "THE FAILED TEST CASE IS " + result.getThrowable());
		
	
		try {
			String screenshotPath = captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
																
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		extent.flush();
		
	}
	


}
