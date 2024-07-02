package com.q4tech.WebAppTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.utils.*;

public class ViewPortfolioTestConEvidencia {
	String url = "http://capital.q4tech.com:7272/sfNetWebApp.Web_acmeus/";
	WebDriver driver;
	String dirEvidencias = "..\\WebAppTest\\Evidencias\\";
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void viewPortfolio() throws IOException, InterruptedException {
		// 1) Hacer clic en Sign In
		// 2) Completar el correo y contraseña
		LoginPage login = new LoginPage(driver);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "1_preLogin.jpg");
		
		login.ingresarCredenciales("testuser1@closeupus.com", "testuser12024");
		
		Thread.sleep(1000);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "2_postLogin.jpg");
		
		DashboardPage dashboard = new DashboardPage(driver);
		
		dashboard.mouseOverToggleAside();
		
		dashboard.clickMenuRelations();
		
		dashboard.clickLinkPortfolios();
		
		dashboard.moveMouseToCenter();
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "3_portfolios_list.jpg");
		
		PortfolioListPage portfolios = new PortfolioListPage(driver);
		
		Thread.sleep(2000);
		
		portfolios.clickItemPortfolio();
		//portfolios.clickdropdownActions();
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "4_portfolio_item.jpg");
		
		portfolios.clickViewPortfolio();
		
		Thread.sleep(2000);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "5_view_portfolio.jpg");
		
	}

	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
