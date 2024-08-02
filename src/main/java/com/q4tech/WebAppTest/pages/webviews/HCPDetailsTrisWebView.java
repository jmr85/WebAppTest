package com.q4tech.WebAppTest.pages.webviews;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.pages.BaseView;

public class HCPDetailsTrisWebView extends BaseView {
	//es un iframe, hay que switchear antes de interactuar con los elementos
	//se switchea dentro del constructor

    // Constructor
	public HCPDetailsTrisWebView(WebDriver driver) {
		super(driver);
		switchToWebviewFrameHCPDetailsTris(); // Switch al iframe (webview)
	}

    // Locators iframe (webview)
	// WebView Frame de relation (HCP Details tris) code file 33
	@FindBy(xpath = "//iframe[@id='webviewFrame']")
	@CacheLookup
	WebElement webviewFrameHCPDetailsTris;

	// Solapa 'Details'
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

	// Edit Customer (Clinical Sites)
	@FindBy(css = "#btn_editCustomer")
	@CacheLookup
	WebElement btnEditCustomer;

	// Acciones dentro de la WebView Frame
	public void clickLinkActions() {
		click(linkActions);
	}
	
	public void clickFaceToFaceCallLink() {
		click(faceToFaceCallLink);
	}
	
	public void clickLinkCustomerDetail() {
		click(linkActions);
	}
	
	public void clickBtnEditCustomer() {
		click(btnEditCustomer);
	}

	public void switchToWebviewFrameHCPDetailsTris() {
		switchToWebviewFrame(webviewFrameHCPDetailsTris);
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(HCPDetailsTrisWebView.class);
	}
}
