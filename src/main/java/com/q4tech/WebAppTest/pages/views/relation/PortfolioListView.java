package com.q4tech.WebAppTest.pages.views.relation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortfolioListView {

	private WebDriver driver;

	// Localizadores Elementos web

	// Item de cartera
	// @FindBy(xpath =
	// "/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[5]/div/div[2]")
	//@FindBy(xpath = "//strong[contains(text(),'ALFANO, AGOSTINO')]")
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[5]/div/div[2]")
	WebElement itemPortfolio;

	// boton acciones del relation, de filtro y demas
	@FindBy(xpath = "//button[@id='dropdownActions']")
	WebElement dropdownActions;
	
	// boton ver detalle cartera
	@FindBy(xpath = "//button[text()=' View Portfolio']")
	@CacheLookup
	WebElement btnViewPortfolio;
	
	// boton Add Portfolio / New Portfolio
	@FindBy(xpath = "//button[@class=\"btn btn-sm btn-primary\"][normalize-space()=\"Add Portfolio\"]")
	@CacheLookup
	WebElement btnAddPortfolio;
	
	// Boton 'Detail'
	@FindBy(xpath = "//span[@id='headermenu_CUSTOMER_DETAIL']")
	@CacheLookup
	WebElement linkCustomerDetail;
	
	// Menu actions de la cartera
	@FindBy(xpath = "//span[@id='button-bookmark']")
	@CacheLookup
	WebElement linkActions; 
	
	@FindBy(xpath = "//a[contains(text(),'Face to Face Call (MD)')]")
	@CacheLookup
	WebElement faceToFaceCallLink;
	
	// Locators iframe (webview)
	// WebView Frame de relation (HCP Details tris) code file 33
	@FindBy(xpath = "//iframe[@id='webviewFrame']")
	@CacheLookup
	WebElement webviewFrameHCPDetailsTris;
	
	// boton dentro de un iframe, hay que switchear antes
	// Edit Customer (Clinical Sites)
	@FindBy(css = "#btn_editCustomer")
	@CacheLookup
	WebElement btnEditCustomer;
	
	// Constructor
	public PortfolioListView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Acciones
	public void clickItemPortfolio() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(itemPortfolio));

		itemPortfolio.click();
	}

	public void clickdropdownActions() {
		dropdownActions.click();
	}

	public void clickViewPortfolio() {
		btnViewPortfolio.click();
	}
	
	public void clickAddPortfolio() {
		btnAddPortfolio.click();
	}
	
	// Acciones dentro de la WebView Frame
	public void clickLinkActions() {
		linkActions.click();
	}
	
	public void clickFaceToFaceCallLink() {
		faceToFaceCallLink.click();
	}
	
	public void clickLinkCustomerDetail() {
		linkCustomerDetail.click();
	}
	
	public void clickBtnEditCustomer() {
		btnEditCustomer.click();
	}
	
	// Acciones switch a un frame (webviews)
	public void switchToWebviewFrameHCPDetailsTris() {
		driver.switchTo().frame(webviewFrameHCPDetailsTris);
	}
	
}
