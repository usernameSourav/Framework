package com.framework.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.utility.BrowserFactory;
import com.framework.utility.ConfigDataProvider;
import com.framework.utility.ExcelDataProvider;
import com.framework.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up dataProvider and report", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/orangehrm" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Checking status");
	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Opening up Application", true);
		driver = BrowserFactory.openApplication(driver, config.getConfigBrowser(), config.getConfigUrl());
	}

	@AfterClass
	public void tearDown() {
		Reporter.log("Closing the browser", true);
		BrowserFactory.tearDown(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {

		Reporter.log("Moving to generate Report", true);

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenhot(driver)).build());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenhot(driver)).build());
		}

		report.flush();
		Reporter.log("Reports generated", true);
	}

}
