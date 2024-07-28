package com.q4tech.WebAppTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginView {
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
		PageFactory.initElements(driver, this);
	}

	// Acciones
	public void doLogin(String email, String password) {
		txtUserName.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
