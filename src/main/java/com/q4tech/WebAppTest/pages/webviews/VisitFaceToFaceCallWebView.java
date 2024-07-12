package com.q4tech.WebAppTest.pages.webviews;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisitFaceToFaceCallWebView {
	// es la unica pantalla de visita webview o iframe, las demas visitas son comun
	// html

	private WebDriver driver;

	// webview de visita Face to Face Call (MD) code file 16
	@FindBy(css = "iframe[id^='IFRAME_']")
	@CacheLookup
	WebElement webviewFrameVisitFateToFace;

	// Solapa Promoted Products
	@FindBy(xpath = "//span[@id='headermenu_DYNAMIC_MENU_PRODUCT_GRID']")
	@CacheLookup
	WebElement tabPromotedProducts;

	// CheckBox Sample Product
	@FindBy(xpath = "//tbody/tr[1]/td[1]/label[1]/span[1]")
	@CacheLookup
	WebElement checkBoxSampleProduct;

	public VisitFaceToFaceCallWebView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Button SAVE visita Face To Face
	// Es parte del modal que contiene el iframe
	// Asi que hay que salir del iframe para que
	// localice al elemento
	@FindBy(xpath = "//button[text()='SAVE']")
	@CacheLookup
	WebElement btnSaveVisit;

	public void switchToWebviewFrameVisitFateToFace() {
		driver.switchTo().frame(webviewFrameVisitFateToFace);
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
		// hay que "deswitchear", volver atras.
		// xq el boton save no esta dentro del iframe
		// si esta dentro del mismo modal
		driver.switchTo().defaultContent();
		
		btnSaveVisit.click();
	}
}
