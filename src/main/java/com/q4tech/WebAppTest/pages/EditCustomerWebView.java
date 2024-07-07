package com.q4tech.WebAppTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerWebView {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"kt_toolbar_container\"]/div[2]/button[2]")
	WebElement btnSaveEditCustomer;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/ng-form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ng-switch[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement txtNameCustomer;
	
	public EditCustomerWebView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBtnSaveEditCustomer() {
		btnSaveEditCustomer.click();
	}
	
	public void clickTxtNameCustomer() {
		txtNameCustomer.click();
	}
	
	public void fillTxtNameCustomer(String name) {
		btnSaveEditCustomer.sendKeys(name);
	}
}
