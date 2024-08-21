package com.q4tech.WebAppTest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.listeners.TestListener;
import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.pages.views.xserver.user.UserListView;
import com.q4tech.WebAppTest.utils.JsonConfigReader;
import com.q4tech.WebAppTest.utils.JsonConfigReader.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners(TestListener.class)
public class GeneratePINTest extends BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(ViewPortfolioTest.class);
	
	@Test
	public void generatePIN() throws IOException, InterruptedException {
		LoginView login = new LoginView(driver);

		User user = JsonConfigReader.getUsers().get(1);
		DashboardView dashboard = login.doLogin(user.getUserName(), user.getPassword());
		
		Thread.sleep(1000);
		
		dashboard.mouseOverToggleAside();
		
		// dashboard.clickMenuRelations();
		
		// dashboard.clickLinkPortfoliosPhysicians();
		
		// dashboard.moveMouseToCenter();
		
		UserListView userList = dashboard.clickMenuXServerUserList();
		
		// PortfolioListView portfolios = new PortfolioListView(driver);

		userList.doGeneratePIN();
		
		// portfolios.clickItemPortfolio();
		//portfolios.clickdropdownActions();
		Thread.sleep(2000);
		// fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "4_portfolio_item");
		// logger.info("Screenshot captured: {}", fileName);

		getScreenshot("PINGenerated");
		
		// portfolios.clickViewPortfolio();
		
		Thread.sleep(2000);
	
	}
}
