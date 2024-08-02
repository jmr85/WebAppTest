package com.q4tech.WebAppTest;

import java.io.IOException;

import org.testng.annotations.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.pages.views.relation.NewPortfolioView;
import com.q4tech.WebAppTest.pages.views.relation.PortfolioListView;
import com.q4tech.WebAppTest.utils.*;

public class NewPortfolioTest extends BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(EditCustomerTest.class);

	@Test
	public void newPortfolio() throws IOException, InterruptedException {
		LoginView login = new LoginView(driver);

		String fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "1_preLogin");
		logger.info("Screenshot captured: {}", fileName);

		DashboardView dashboard = login.doLogin("testuser1@closeupus.com", "testuser12024");

		Thread.sleep(1000);

		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "2_postLogin");
		logger.info("Screenshot captured: {}", fileName);

		dashboard.mouseOverToggleAside();
		dashboard.clickMenuRelations();
		dashboard.clickLinkPortfoliosClinicalSites();
		dashboard.moveMouseToCenter();

		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "3_portfolios_list");
		logger.info("Screenshot captured: {}", fileName);

		PortfolioListView portfolios = new PortfolioListView(driver);

		Thread.sleep(2000);

		portfolios.clickItemPortfolio();
		// portfolios.clickdropdownActions();

		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "4_portfolio_item");
		logger.info("Screenshot captured: {}", fileName);

		// esperar a que se vayan los Toast de error
		Thread.sleep(6000);// OK

		// CLICK "+NEW PORTFOLIO"
		portfolios.clickAddPortfolio();
		
		Thread.sleep(2000);

		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "8_click_save_edit_customer");
		logger.info("Screenshot captured: {}", fileName);
		
		NewPortfolioView newPortfolioView = new NewPortfolioView(driver);
		
		newPortfolioView.clickBtnSelectCustomer();
		newPortfolioView.searchCustomer("john");
		
		Thread.sleep(1000);
		
		newPortfolioView.clickLinkCustomer();
		
		Thread.sleep(1000);
		
		//newPortfolioView.selectSpecialty("ALLERGY");
		
		//newPortfolioView.selectSamplesAllowed("Yes");
		
		newPortfolioView.clickBtnSaveNewPortfolio();
		
		Thread.sleep(1000);
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "9_click_save_new_portfolio");
		logger.info("Screenshot captured: {}", fileName);
	}
}