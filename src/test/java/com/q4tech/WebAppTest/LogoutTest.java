package com.q4tech.WebAppTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

	// String url = "http://capital.q4tech.com:7272/sfNetWebApp.Web_acmeus/";
	WebDriver driver;
	// String dirEvidencias = "..\\WebAppTest\\Evidencias\\";
	
	@BeforeSuite
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		double zoom = 0.67;
		options.addArguments("--force-device-scale-factor=" + zoom);
		
		driver = new ChromeDriver(options);
		driver.get(JsonConfigReader.getBaseUrl());
		logger.info("Navigated to URL: {}", JsonConfigReader.getBaseUrl());
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void logout() throws IOException, InterruptedException {
		LoginView login = new LoginView(driver);
		logger.info("Starting login process");
		
		CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "1_preLogin.jpg");
		
		User user = JsonConfigReader.getUsers().get(0);
		login.doLogin(user.getUserName(), user.getPassword());

		logger.info("Credentials entered");

		Thread.sleep(1000);
		
		CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "2_postLogin.jpg");
		
		DashboardView dashboard = new DashboardView(driver);
		logger.info("Navigating to dashboard");
		
		dashboard.doLogOut();
		logger.info("Logout completed");

		// Espero 2 segundos para el screenshot sobre login
		Thread.sleep(2000);
		CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "3_doLogout.jpg");
	}

	@AfterSuite
	public void tearDown() {
		//driver.close();
		logger.info("========== tearDown ===========");
	}
}
