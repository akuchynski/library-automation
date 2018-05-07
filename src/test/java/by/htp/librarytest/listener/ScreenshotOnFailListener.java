package by.htp.librarytest.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import by.htp.librarytest.driver.DriverSingleton;

public class ScreenshotOnFailListener implements ITestListener, ISuiteListener, IInvokedMethodListener {
	private final Logger logger = LogManager.getRootLogger();
	public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

	}

	public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

	}

	public void onStart(ISuite iSuite) {

	}

	public void onFinish(ISuite iSuite) {

	}

	public void onTestStart(ITestResult iTestResult) {
		logger.info("Listener - start of the test");
	}

	public void onTestSuccess(ITestResult iTestResult) {

	}

	public void onTestFailure(ITestResult iTestResult) {
		logger.info("Listener - failed test");
		takeScreenshot();
	}

	public void onTestSkipped(ITestResult iTestResult) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public void onStart(ITestContext iTestContext) {

	}

	public void onFinish(ITestContext iTestContext) {

	}


	private void takeScreenshot() {

		logger.info("Listener - takeScreenshot");
		File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver())
				.getScreenshotAs(OutputType.FILE);
		try {

			File f = new File(".//target/screenshots/screenshot.png");
			FileUtils.copyFile(screenCapture, f);
			Reporter.log("<img src=\"" + f.getAbsolutePath() + "\"/>");
		} catch (IOException e) {
			logger.info("Failed to save screenshot: " + e.getLocalizedMessage());
		}
	}
}