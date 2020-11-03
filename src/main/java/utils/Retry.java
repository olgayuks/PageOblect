package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int attempt =1;
    private static final int max_retry = 5;

    @Override
    public boolean retry(ITestResult iTestResult) {
       if (!iTestResult.isSuccess()) {
           if (attempt < max_retry){
               attempt++;
               iTestResult.setStatus(ITestResult.FAILURE);
               System.out.println("Retrying one more time");
               return true;
           } else {
               iTestResult.setStatus(ITestResult.FAILURE);
           }
       } else {
           iTestResult.setStatus(ITestResult.SUCCESS);
       }
        return false;
    }
}
