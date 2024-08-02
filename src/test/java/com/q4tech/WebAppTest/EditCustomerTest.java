package com.q4tech.WebAppTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.pages.views.customer.EditCustomerView;
import com.q4tech.WebAppTest.pages.views.relation.PortfolioListView;
import com.q4tech.WebAppTest.pages.webviews.HCPDetailsTrisWebView;
import com.q4tech.WebAppTest.utils.*;

public class EditCustomerTest extends BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(EditCustomerTest.class);
	
	@Test
	public void editCustomer() throws IOException, InterruptedException {
		LoginView login = new LoginView(driver);
		
		String fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "1_preLogin");
		logger.info("Screenshot captured: {}", fileName);
		
		DashboardView dashboard = login.doLogin("testuser1@closeupus.com", "testuser12024");
		
		Thread.sleep(1000);

		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "1_postLogin");
		logger.info("Screenshot captured: {}", fileName);
		
		dashboard.mouseOverToggleAside();
		dashboard.clickMenuRelations();
		dashboard.clickLinkPortfoliosClinicalSites();
		dashboard.moveMouseToCenter();
	
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "2_portfolios_list");
		logger.info("Screenshot captured: {}", fileName);
		
		PortfolioListView portfolios = new PortfolioListView(driver);
		
		Thread.sleep(2000);
		
		portfolios.clickItemPortfolio();
		
		CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "4_portfolio_item.jpg");
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "3_portfolio_item");
		logger.info("Screenshot captured: {}", fileName);
		
		Thread.sleep(3000);
		
		HCPDetailsTrisWebView hcp = new HCPDetailsTrisWebView(driver);
		
		//esperar a que se vayan los Toast de error
		Thread.sleep(6000);// OK
		
		hcp.clickBtnEditCustomer();
		
		Thread.sleep(2000);
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "4_click_edit_customer");
		logger.info("Screenshot captured: {}", fileName);

		// hay que "deswitchear", volver atras para
		// luego volver switchear otro iframe (webview)
		// o solo volver a interactuar normal
		driver.switchTo().defaultContent();
		
		EditCustomerView editCustomer = new EditCustomerView(driver);
		
		//editCustomer.clickBtnSaveEditCustomer();
		
		Thread.sleep(2000);
		
		editCustomer.clickTxtNameCustomer();
		
		Thread.sleep(2000);
		
		editCustomer.fillTxtNameCustomer("Pepito");
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "5_edit_name_customer");
		logger.info("Screenshot captured: {}", fileName);
		
		editCustomer.clickBtnSaveEditCustomer();
		
		Thread.sleep(2000);
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "6_click_save_edit_customer");
		logger.info("Screenshot captured: {}", fileName);
	}
}