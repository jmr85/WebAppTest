package com.q4tech.WebAppTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutTest {
	private static final Logger logger = LoggerFactory.getLogger(LogoutTest.class);

	String url = "http://capital.q4tech.com:7272/sfNetWebApp.Web_acmeus/";
	WebDriver driver;
	String dirEvidencias = "..\\WebAppTest\\Evidencias\\";
	
	@BeforeSuite
	public void setUp() {
		logger.info("========== setUp ===========");
		logger.info("========== Starting test cases execution ===========");

		ChromeOptions options = new ChromeOptions();
		double zoom = 0.67;
		options.addArguments("--force-device-scale-factor=" + zoom);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		logger.info("Navigated to URL: {}", url);
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void logout() throws IOException, InterruptedException {
		logger.info("========== starting test case: Logout ===========");

		// 1) Hacer clic en Sign In
		// 2) Completar el correo y contraseña
		LoginView login = new LoginView(driver);
		logger.info("Starting login process");
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "1_preLogin.jpg");
		
		login.ingresarCredenciales("testuser1@closeupus.com", "testuser12024");
		logger.info("Credentials entered");

		Thread.sleep(1000);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "2_postLogin.jpg");
		
		DashboardView dashboard = new DashboardView(driver);
		logger.info("Navigating to dashboard");
		
		dashboard.doLogOut();
		logger.info("Logout completed");

		// Espero 2 segundos para el screenshot sobre login
		Thread.sleep(2000);
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "3_doLogout.jpg");
		
		logger.info("========== ending test case: Logout ===========");
	}

	@AfterSuite
	public void tearDown() {
		//driver.close();
		logger.info("========== ending test cases execution ===========");
		logger.info("========== tearDown ===========");
	}
}
