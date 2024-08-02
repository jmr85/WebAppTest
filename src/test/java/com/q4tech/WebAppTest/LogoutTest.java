package com.q4tech.WebAppTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.listeners.TestListener;
import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.utils.*;
import com.q4tech.WebAppTest.utils.JsonConfigReader.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners(TestListener.class)
public class LogoutTest {
	private static final Logger logger = LoggerFactory.getLogger(LogoutTest.class);

	private LoginView loginView;
	private DashboardView dashboardView;

	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(JsonConfigReader.getBaseUrl());
		logger.info("Navigated to URL: {}", JsonConfigReader.getBaseUrl());
		driver.manage().window().maximize();

		loginView = new LoginView(driver);
	}
	
	@Test(priority = 1)
	public void login() throws IOException {
		logger.info("Starting login process");
		
		String fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "1_preLogin");
		logger.info("Screenshot captured: {}", fileName);
		
		User user = JsonConfigReader.getUsers().get(0);
		dashboardView = loginView.doLogin(user.getUserName(), user.getPassword());

		logger.info("Credentials entered");
	}

	@Test(priority = 2, dependsOnMethods = "login")
	public void logout() throws IOException, InterruptedException {

		Thread.sleep(1000);

		String fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "2_postLogin");
		logger.info("Screenshot captured: {}", fileName);
		
		//DashboardView dashboard = new DashboardView(driver);
		logger.info("Navigating to dashboard");
		
		dashboardView.doLogOut();
		logger.info("Logout completed");

		// Espero 2 segundos para el screenshot sobre login
		Thread.sleep(2000);

		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "3_doLogout");
		logger.info("Screenshot captured: {}", fileName);
	}

	@AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
			logger.info("tearDown");
		}
    }
}
