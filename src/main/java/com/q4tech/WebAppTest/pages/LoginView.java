package com.q4tech.WebAppTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView extends BaseView {
	// Elementos web
	@FindBy(xpath = "//input[@id='txtUserName']")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(xpath = "//input[@id='txtUserPassword']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[@id='btnLogin']")
	@CacheLookup
	WebElement btnLogin;

	// Constructor
	public LoginView(WebDriver driver) {
		super(driver);
	}

	// Acciones
	public DashboardView doLogin(String userName, String password) {
		sendKeys(txtUserName, userName);
        sendKeys(txtPassword, password);
        click(btnLogin); // Usa FluentWait para esperar que el botón sea clickeable

		return new DashboardView(super.driver);
	}
	
	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(LoginView.class);
	}
}
