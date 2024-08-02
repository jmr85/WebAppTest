package com.q4tech.WebAppTest.pages.views.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.pages.BaseView;

public class EditCustomerView extends BaseView {
	//Locators
	@FindBy(xpath = "//*[@id=\"kt_toolbar_container\"]/div[2]/button[2]")
	@CacheLookup
	WebElement btnSaveEditCustomer;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/ng-form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ng-switch[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement txtNameCustomer;
	
	//Contructor
	public EditCustomerView(WebDriver driver) {
		super(driver);
	}
	
	//Acciones
	public void clickTxtNameCustomer() {
		click(txtNameCustomer);
	}
	
	public void fillTxtNameCustomer(String name) {
		sendKeys(txtNameCustomer, name);
	}

	public void clickBtnSaveEditCustomer() {
		click(btnSaveEditCustomer);
	}

	public void doSaveEditCustomer(String customerName) {
		clickTxtNameCustomer();
		fillTxtNameCustomer(customerName);
		clickBtnSaveEditCustomer();
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(EditCustomerView.class);
	}
}
