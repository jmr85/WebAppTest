package com.q4tech.WebAppTest.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("{} started", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("{} passed", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("{} failed", result.getName());
        logger.info("Test failed: " + result.getMethod().getMethodName());
        logger.debug(null, result);
        // Mas detalles sobre el fallo
        logger.error("Exception: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("{} started", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("{} finished", context.getName());
    }
}
