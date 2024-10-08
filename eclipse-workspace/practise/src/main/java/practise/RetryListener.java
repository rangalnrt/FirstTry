package practise;

import org.testng.ITestResult;


import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;


public class RetryListener implements ITestNGListener {
    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    public boolean onTestFailure(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // Do not retry
    }
}
