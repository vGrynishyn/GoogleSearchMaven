package core;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LogInformation.info("==============================================");
        LogInformation.info("Start test: " + result.getName());
        LogInformation.info("==============================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogInformation.info("==============================================");
        LogInformation.info("Test finished successfuly: " + result.getName());
        LogInformation.info("==============================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
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

    }
}