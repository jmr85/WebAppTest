package com.q4tech.WebAppTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardView extends BaseView {
	// Localizadores Elementos web
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/*[1]")
	@CacheLookup
	WebElement toggleAside;

	// User Follow Button	
	@FindAll({
		@FindBy(id="kt_user_follow_button"), //Matches
		@FindBy(xpath = "//span[@class='btn-label text-break']") //doesn't match
	})
	@CacheLookup
	WebElement btnUser;

	// Logout Button
	@FindAll({
		@FindBy(id = "btnLogout"),
		@FindBy(xpath = "//span[@id='btnLogout']/span[2]"),
		@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	})	
	@CacheLookup
	WebElement btnLogout;

	// Menu Portfolios
	@FindBy(xpath = "//span[@id='menu_relations']")
	@CacheLookup
	WebElement menuRelations;

	// Grupo de carteras Physicians
	@FindBy(xpath = "//a[@id='menu_relations_5']")
	WebElement linkPortfoliosPhysicians;
	
	// Grupo de carteras Clinical Sites
	@FindBy(xpath = "//a[@id='menu_relations_9']")
	WebElement linkPortfoliosClinicalSites;

	// WebView MAIN TRIS code file 18
	@FindBy(id = "iframeContainer")
	@CacheLookup
	WebElement webviewFrameMainTris;

	// Constructor
	public DashboardView(WebDriver driver) {
		super(driver);
	}

	// Acciones
	public void mouseOverToggleAside() {
		mouseOver(toggleAside);
	}

	public void moveMouseToCenter() {
		moveMouseToCenter(toggleAside);
	}

	// Acciones
	public WebDriver switchToWebviewFrameMainTris() {
		//return driver.switchTo().frame(webviewFrameMainTris);
		//return switchToWebviewFrame(webviewFrameMainTris);
		return switchToWebviewFrame(webviewFrameMainTris);
	}

	public WebDriver switchToDefaultContent() {
		return switchToDefaultContent();
	}

	public void clickMenuRelations() {
		menuRelations.click();
	}

	public void clickLinkPortfoliosPhysicians() {
		clickWithJS(linkPortfoliosPhysicians);
	}
	
	public void clickLinkPortfoliosClinicalSites() {
		click(linkPortfoliosClinicalSites);
	}

	public void doLogOut() {
		this.mouseOverToggleAside();
		clickWithJS(btnUser);
		//clickWithRetry(btnLogout, MAX_ATTEMPTS);
		clickWithJS(btnLogout);
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(DashboardView.class);
	}
}
