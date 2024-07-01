package com.q4tech.WebAppTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Elementos web
	@FindBy(xpath = "//input[@id='txtUserName']")
	WebElement txtUserName;

	@FindBy(xpath = "//input[@id='txtUserPassword']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@id='btnLogin']")
	WebElement btnLogin;

	// Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Acciones
	public void ingresarCredenciales(String email, String password) {
		txtUserName.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
