package com.sevenrmartsupermarket.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 4;

	public boolean retry(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && counter < retryLimit) {
			counter++;
			return true;
		} else {
			return false;
		}
	}

}
