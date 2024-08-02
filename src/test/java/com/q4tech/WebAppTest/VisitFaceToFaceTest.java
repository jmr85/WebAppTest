package com.q4tech.WebAppTest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.listeners.TestListener;
import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.pages.views.relation.PortfolioListView;
import com.q4tech.WebAppTest.pages.webviews.HCPDetailsTrisWebView;
import com.q4tech.WebAppTest.pages.webviews.VisitFaceToFaceCallWebView;
import com.q4tech.WebAppTest.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners(TestListener.class)
public class VisitFaceToFaceTest extends BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(VisitFaceToFaceTest.class);
	
	@Test
	public void saveVisit() throws IOException, InterruptedException {
		LoginView login = new LoginView(driver);
		logger.info("Starting login process");
		
		String fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "1_preLogin");
		logger.info("Screenshot captured: {}", fileName);
		
		DashboardView dashboard = login.doLogin("testuser1@closeupus.com", "testuser12024");
		logger.info("Credentials entered");

		Thread.sleep(1000);
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "2_postLogin");
		logger.info("Screenshot captured: {}", fileName);
		
		logger.info("Navigating to dashboard");
		
		dashboard.mouseOverToggleAside();
		dashboard.clickMenuRelations();
		dashboard.clickLinkPortfoliosPhysicians();
		dashboard.moveMouseToCenter();
		logger.info("Navigation to portfolios list completed");
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "3_portfolios_list");
		logger.info("Screenshot captured: {}", fileName);
		
		PortfolioListView portfolios = new PortfolioListView(driver);
		
		Thread.sleep(2000);
		
		portfolios.clickItemPortfolio();
		logger.info("Portfolio selected");
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "4_portfolio_item");
		logger.info("Screenshot captured: {}", fileName);
		
		Thread.sleep(3000);
		
		HCPDetailsTrisWebView hcpDetailsTris = new HCPDetailsTrisWebView(driver);
		
		//esperar a que se vayan los Toast de error
		Thread.sleep(6000);// OK
		
		hcpDetailsTris.clickLinkActions();
		hcpDetailsTris.clickFaceToFaceCallLink();
		logger.info("Initiating new Face to Face visit");
		
		Thread.sleep(2000);
		
		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "5_click_new_visit");
		logger.info("Screenshot captured: {}", fileName);
		
		// hay que "deswitchear", volver atras para
		// luego volver switchear otro iframe (webview)
		driver.switchTo().defaultContent();
		logger.info("Returning to main content");
		
		Thread.sleep(2000);
		
		VisitFaceToFaceCallWebView visitFaceToFace = new VisitFaceToFaceCallWebView(driver);

		Thread.sleep(1000);
		
		visitFaceToFace.clickTabPromotedProducts();
		logger.info("Promoted Products tab selected");
		visitFaceToFace.clickCheckBoxSampleProduct();
		logger.info("Sample product selected");

		visitFaceToFace.clickBtnSaveVisit();
		logger.info("Visit saved");

		fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "6_click_save_visit");
		logger.info("Screenshot captured: {}", fileName);

		dashboard.doLogOut();
		logger.info("Logout completed");
	}
}
