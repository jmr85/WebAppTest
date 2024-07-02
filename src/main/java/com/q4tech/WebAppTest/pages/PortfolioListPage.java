package com.q4tech.WebAppTest.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortfolioListPage {

	private WebDriver driver;

	// Localizadores Elementos web

	// Item de cartera
	// @FindBy(xpath =
	// "/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[5]/div/div[2]")
	@FindBy(xpath = "//strong[contains(text(),'ALFANO, AGOSTINO')]")
	WebElement itemPortfolio;

	// boton acciones
	@FindBy(xpath = "//button[@id='dropdownActions']")
	WebElement dropdownActions;

	@FindBy(xpath = "//button[text()=' View Portfolio']")
	WebElement btnViewPortfolio;

	// Constructor
	public PortfolioListPage(WebDriver driver) {
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
}
