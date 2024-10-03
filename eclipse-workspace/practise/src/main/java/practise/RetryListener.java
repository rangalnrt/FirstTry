package practise;

import org.testng.ITestResult;


import org.testng.IRetryAnalyzer;

public class RetryListener implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // Do not retry
    }
}
