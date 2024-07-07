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
import com.q4tech.WebAppTest.pages.webviews.EditCustomerWebView;
import com.q4tech.WebAppTest.utils.*;

public class EditCustomerTest {
	
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
	public void editCustomer() throws IOException, InterruptedException {
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
		
		dashboard.clickLinkPortfoliosClinicalSites();
		
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
		
		portfolios.switchToWebviewFrame();
		
		//portfolios.clickLinkCustomerDetail(); OK
		
		//esperar a que se vayan los Toast de error
		Thread.sleep(6000);// OK
		
		portfolios.clickBtnEditCustomer();
		
		Thread.sleep(2000);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "5_click_edit_customer.jpg");
		
		// hay que "deswitchear", volver atras para
		// luego volver switchear otro iframe (webview)
		// o solo volver a interactuar normal
		driver.switchTo().defaultContent();
		
		EditCustomerWebView editCustomer = new EditCustomerWebView(driver);
		
		//editCustomer.clickBtnSaveEditCustomer();
		
		Thread.sleep(2000);
		
		//CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "6_click_save_edit_customer.jpg");
		
		editCustomer.clickTxtNameCustomer();
		
		Thread.sleep(2000);
		
		editCustomer.fillTxtNameCustomer("Pepito");
		
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "7_edit_name_customer.jpg");
		
		editCustomer.clickBtnSaveEditCustomer();
		
		Thread.sleep(2000);
		
		CaptureEvidenceUtil.getScreenshot(driver, dirEvidencias, "8_click_save_edit_customer.jpg");
		
	}

	@AfterSuite
	public void tearDown() {
		//driver.close();
	}

}
