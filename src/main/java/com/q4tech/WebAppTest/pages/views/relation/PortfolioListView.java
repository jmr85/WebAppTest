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
	
	// Solapa Promoted Products
	@FindBy(xpath = "//span[@id='headermenu_DYNAMIC_MENU_PRODUCT_GRID']")
	@CacheLookup
	WebElement tabPromotedProducts;
	
	// CheckBox Sample Product
	@FindBy(xpath = "//tbody/tr[1]/td[1]/label[1]/span[1]")
	@CacheLookup
	WebElement checkBoxSampleProduct;
	
	// Button SAVE visita Face To Face
	// Es parte del modal que contiene el iframe
	// Asi que hay que salir del iframe para que
	// localice al elemento
	@FindBy(xpath = "//button[text()='SAVE']")
	@CacheLookup
	WebElement btnSaveVisit;
	
	// Locators iframe (webview)
	// WebView Frame de relation
	@FindBy(xpath = "//iframe[@id='webviewFrame']")
	@CacheLookup
	WebElement webviewFrame;
		
	// webview de visita Face to Face Call (MD)
	// hay que volver hacer porque es dinamico el ID
	//IFRAME_05262024_042657
	//IFRAME_05332024_043311
	//IFRAME_05362024_053608
	//IFRAME_05332024_063336
	//@FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/iframe[1]")
	//@FindBy(xpath = "//iframe[matches(@id, 'IFRAME_\\d{8}_\\d{6}')]")
	//@FindBy(xpath = "//iframe[contains(@id, 'IFRAME_') and contains(@id, '2024_')]")
	@FindBy(css = "iframe[id^='IFRAME_']")
	@CacheLookup
	WebElement webviewFrameVisitFateToFace;
	
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
	
	public void clickTabPromotedProducts() {
		tabPromotedProducts.click();
	}
	
	public void clickCheckBoxSampleProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxSampleProduct));
		checkBoxSampleProduct.click();
	}
	
	public void clickBtnSaveVisit() {
		btnSaveVisit.click();
	}
	
	public void clickBtnEditCustomer() {
		btnEditCustomer.click();
	}
	
	// Acciones switch a un frame (webviews)
	public void switchToWebviewFrame() {
		driver.switchTo().frame(webviewFrame);
	}
	
	public void switchToWebviewFrameVisitFateToFace() {
		driver.switchTo().frame(webviewFrameVisitFateToFace);
	}
	
}
