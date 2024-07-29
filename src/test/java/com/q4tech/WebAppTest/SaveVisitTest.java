package com.q4tech.WebAppTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.pages.views.relation.PortfolioListView;
import com.q4tech.WebAppTest.pages.webviews.VisitFaceToFaceCallWebView;
import com.q4tech.WebAppTest.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveVisitTest {
	private static final Logger logger = LoggerFactory.getLogger(SaveVisitTest.class);

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
	public void saveVisit() throws IOException, InterruptedException {
		logger.info("========== starting test case: Save Visit ===========");

		// 1) Hacer clic en Sign In
		// 2) Completar el correo y contraseña
		LoginView login = new LoginView(driver);
		logger.info("Starting login process");
		
		CaptureEvidence.getScreenshot(driver, dirEvidencias, "1_preLogin.jpg");
		
		login.doLogin("testuser1@closeupus.com", "testuser12024");
		logger.info("Credentials entered");

		Thread.sleep(1000);
		
		CaptureEvidence.getScreenshot(driver, dirEvidencias, "2_postLogin.jpg");
		
		DashboardView dashboard = new DashboardView(driver);
		logger.info("Navigating to dashboard");
		
		dashboard.mouseOverToggleAside();
		dashboard.clickMenuRelations();
		dashboard.clickLinkPortfoliosPhysicians();
		dashboard.moveMouseToCenter();
		logger.info("Navigation to portfolios list completed");
		
		CaptureEvidence.getScreenshot(driver, dirEvidencias, "3_portfolios_list.jpg");
		
		PortfolioListView portfolios = new PortfolioListView(driver);
		
		Thread.sleep(2000);
		
		portfolios.clickItemPortfolio();
		logger.info("Portfolio selected");
		
		CaptureEvidence.getScreenshot(driver, dirEvidencias, "4_portfolio_item.jpg");
		
		Thread.sleep(3000);
		
		portfolios.switchToWebviewFrameHCPDetailsTris();
		logger.info("Switched to HCP details frame");
		
		//esperar a que se vayan los Toast de error
		Thread.sleep(6000);// OK
		
		portfolios.clickLinkActions();
		portfolios.clickFaceToFaceCallLink();
		logger.info("Initiating new Face to Face visit");
		
		Thread.sleep(2000);
		
		CaptureEvidence.getScreenshot(driver, dirEvidencias, "5_click_new_visit.jpg");
		
		// hay que "deswitchear", volver atras para
		// luego volver switchear otro iframe (webview)
		driver.switchTo().defaultContent();
		logger.info("Returning to main content");
		
		Thread.sleep(2000);
		
		VisitFaceToFaceCallWebView visitFaceToFace = new VisitFaceToFaceCallWebView(driver);
		visitFaceToFace.switchToWebviewFrameVisitFateToFace();
		logger.info("Switched to Face to Face visit frame");

		Thread.sleep(1000);
		
		visitFaceToFace.clickTabPromotedProducts();
		logger.info("Promoted Products tab selected");
		visitFaceToFace.clickCheckBoxSampleProduct();
		logger.info("Sample product selected");

		visitFaceToFace.clickBtnSaveVisit();
		logger.info("Visit saved");
		
		CaptureEvidence.getScreenshot(driver, dirEvidencias, "6_click_save_visit.jpg");
		
		logger.info("========== ending test case: Save Visit ===========");
	}

	@AfterSuite
	public void tearDown() {
		//driver.close();
		logger.info("========== ending test cases execution ===========");
		logger.info("========== tearDown ===========");
	}
}
