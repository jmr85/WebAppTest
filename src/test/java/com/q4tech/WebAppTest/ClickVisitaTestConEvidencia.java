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
import com.q4tech.WebAppTest.utils.*;

public class ClickVisitaTestConEvidencia {
	String url = "http://capital.q4tech.com:7272/sfNetWebApp.Web_acmeus/";
	WebDriver driver;
	String dirEvidencias = "..\\WebAppTest\\Evidencias\\";
	
	@BeforeSuite
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		double zoom = 0.67;
		options.addArguments("--force-device-scale-factor=" + zoom);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void viewPortfolio() throws IOException, InterruptedException {
		// 1) Hacer clic en Sign In
		// 2) Completar el correo y contraseña
		LoginView login = new LoginView(driver);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "1_preLogin.jpg");
		
		login.ingresarCredenciales("testuser1@closeupus.com", "testuser12024");
		
		Thread.sleep(1000);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "2_postLogin.jpg");
		
		DashboardView dashboard = new DashboardView(driver);
		
		dashboard.mouseOverToggleAside();
		
		dashboard.clickMenuRelations();
		
		dashboard.clickLinkPortfoliosPhysicians();
		
		dashboard.moveMouseToCenter();
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "3_portfolios_list.jpg");
		
		PortfolioListView portfolios = new PortfolioListView(driver);
		
		Thread.sleep(2000);
		
		portfolios.clickItemPortfolio();
		//portfolios.clickdropdownActions();
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "4_portfolio_item.jpg");
		
		//portfolios.clickViewPortfolio();
		
		//portfolios.clickLinkActions();
		
		Thread.sleep(3000);
		
		portfolios.switchToWebviewFrameHCPDetailsTris();
		
		//portfolios.clickLinkCustomerDetail(); OK
		
		//esperar a que se vayan los Toast de error
		Thread.sleep(6000);// OK
		
		portfolios.clickLinkActions();
		
		portfolios.clickFaceToFaceCallLink();
		
		Thread.sleep(2000);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "5_click_new_visit.jpg");
		
	}

	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
