package com.q4tech.WebAppTest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.listeners.TestListener;
import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.pages.views.relation.PortfolioListView;
import com.q4tech.WebAppTest.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners(TestListener.class)
public class ViewPortfolioTest extends BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(ViewPortfolioTest.class);
	
	@Test
	public void viewPortfolio() throws IOException, InterruptedException {
		LoginView login = new LoginView(driver);

		String fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "1_preLogin");
		logger.info("Screenshot captured: {}", fileName);
		
		DashboardView dashboard = login.doLogin("testuser1@closeupus.com", "testuser12024");
		
		Thread.sleep(1000);
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "2_postLogin");
		logger.info("Screenshot captured: {}", fileName);
		
		dashboard.mouseOverToggleAside();
		
		dashboard.clickMenuRelations();
		
		dashboard.clickLinkPortfoliosPhysicians();
		
		dashboard.moveMouseToCenter();
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "3_portfolios_list");
		logger.info("Screenshot captured: {}", fileName);
		
		PortfolioListView portfolios = new PortfolioListView(driver);
		
		Thread.sleep(2000);
		
		portfolios.clickItemPortfolio();
		//portfolios.clickdropdownActions();
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "4_portfolio_item");
		logger.info("Screenshot captured: {}", fileName);
		
		portfolios.clickViewPortfolio();
		
		Thread.sleep(2000);
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "5_view_portfolio");
		logger.info("Screenshot captured: {}", fileName);
	}
}
