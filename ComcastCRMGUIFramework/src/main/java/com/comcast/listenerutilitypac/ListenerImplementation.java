package com.comcast.listenerutilitypac;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testCaseName=result.getMethod().getMethodName();
		Reporter.log(testCaseName+"Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCaseName=result.getMethod().getMethodName();
		Reporter.log(testCaseName+"Execution Passed!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCaseName=result.getMethod().getMethodName();
		Reporter.log(testCaseName+"Execution Failed!!");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testCaseName=result.getMethod().getMethodName();
		Reporter.log(testCaseName+"Execution Skipped!!");
	}
	

}
