package testListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import stepDefinations.BaseClass;

public class Listener extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test has started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test is Successful");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test has failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test is finished");
		
	}



}

