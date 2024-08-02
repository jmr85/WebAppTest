package com.q4tech.WebAppTest.pages.webviews;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.pages.BaseView;

public class VisitFaceToFaceCallWebView extends BaseView {
	// es la unica pantalla de visita webview o iframe, las demas visitas son comun
	// html

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

	// Constructor
	public VisitFaceToFaceCallWebView(WebDriver driver) {
		super(driver);
		switchToWebviewFrameVisitFateToFace(); // Switch al iframe (webview)
	}

	// Button SAVE visita Face To Face
	// Es parte del modal que contiene el iframe
	// Asi que hay que salir del iframe para que
	// localice al elemento
	@FindBy(xpath = "//button[text()='SAVE']")
	@CacheLookup
	WebElement btnSaveVisit;

	// Acciones dentro de la WebView Frame
	public void switchToWebviewFrameVisitFateToFace() {
		switchToWebviewFrame(webviewFrameVisitFateToFace);
	}

	public void clickTabPromotedProducts() {
		click(tabPromotedProducts);
	}

	public void clickCheckBoxSampleProduct() {
		click(checkBoxSampleProduct);
	}

	public void clickBtnSaveVisit() {
		// hay que "deswitchear", volver atras.
		// xq el boton save no esta dentro del iframe
		// si esta dentro del mismo modal
		switchToDefaultContent();	
		click(btnSaveVisit);
	}

	public void doVisitFaceToFaceCall() {
		clickTabPromotedProducts();
		getLogger().info("Promoted Products tab selected");
		clickCheckBoxSampleProduct();
		getLogger().info("Sample product selected");
		clickBtnSaveVisit();
		getLogger().info("Visit saved");
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(VisitFaceToFaceCallWebView.class);
	}
}
