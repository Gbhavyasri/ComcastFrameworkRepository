package com.comcast.listenerutilitypac;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ListImpClass implements ITestListener,ISuiteListener{
	ExtentReports report ;
	ExtentTest test;
  public void onStart(ISuite suite) {
	  System.out.println("report Configuration");
	  ExtentSparkReporter spark=new ExtentSparkReporter("./LowLevelReport/VtigerReport.html");
	  spark.config().setDocumentTitle("Advance Report");
	  spark.config().setReportName("Vtiger report");
	  spark.config().setTheme(Theme.STANDARD);
	  
	  report =new ExtentReports();
	  report.attachReporter(spark);
	  report.setSystemInfo("OS", "Window");
	  report.setSystemInfo("Laptop", "Dell");
	  report.setSystemInfo("Browser", "Chrome");
	  report.setSystemInfo("IDE", "Eclipse");
  }
  public void onFinish(ISuite suite) {
//	  System.out.println("report Backup");
	  report.flush();
  }
  public void onTestStart(ITestResult result) {
//	  System.out.println("===="+result.getMethod().getMethodName()+"====START=======");
	 String testcase= result.getMethod().getMethodName();
	 test=report.createTest(testcase);
	 test.log(Status.INFO,testcase+"Execution Started");
	  
  }
  public void onTestSuccess(ITestResult result) {
	 String testCase= result.getMethod().getMethodName();
//	  System.out.println("===="+result.getMethod().getMethodName()+"====END=======");
	  test.log(Status.PASS, testCase+"Execution Passed");
  }
  public void onTestFailure(ITestResult result) {
	  
	  WebDriver driver=BaseClass.sdriver;
	  String testName=result.getMethod().getMethodName();
	  test.log(Status.FAIL, testName+"Execution Failed");
	 TakesScreenshot screenShot=(TakesScreenshot)driver;
	String src= screenShot.getScreenshotAs(OutputType.BASE64);
	test.addScreenCaptureFromBase64String(src);
	String time=new Date().toString().replace(" ", "_").replace(":", "_");
//	try {
//		FileHandler.copy(src, new File("./Screenshots/"+testName+time+".png"));
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
  }
  @Override
	public void onTestSkipped(ITestResult result) {
		String testCaseName=result.getMethod().getMethodName();
//		Reporter.log(testCaseName+"Execution Skipped!!");
		test.log(Status.SKIP, testCaseName+"Execution Skipped!!");
	}
}
