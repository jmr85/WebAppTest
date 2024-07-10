package com.q4tech.WebAppTest.pages.views.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class EditCustomerView {
	
	private static final int TIMEOUT = 3;// segundos
	
	@FindBy(xpath = "//*[@id=\"kt_toolbar_container\"]/div[2]/button[2]")
	@CacheLookup
	WebElement btnSaveEditCustomer;
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/ng-form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ng-switch[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement txtNameCustomer;
	
	public EditCustomerView(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}
	
	public void clickBtnSaveEditCustomer() {
		btnSaveEditCustomer.click();
	}
	
	public void clickTxtNameCustomer() {
		txtNameCustomer.click();
	}
	
	public void fillTxtNameCustomer(String name) {
		txtNameCustomer.sendKeys(name);
	}
}
