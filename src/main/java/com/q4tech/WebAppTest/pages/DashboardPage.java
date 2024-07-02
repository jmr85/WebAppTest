package com.q4tech.WebAppTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	private WebDriver driver;

	// Localizadores Elementos web
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/*[1]")
	WebElement toggleAside;

	// Menu Portfolios
	@FindBy(xpath = "//span[@id='menu_relations']")
	WebElement menuRelations;

	// Grupo de carteras Physicians
	@FindBy(xpath = "//a[@id='menu_relations_5']")
	WebElement linkPortfolios;

	// Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Acciones
	public void mouseOverToggleAside() {
		new Actions(driver).moveToElement(toggleAside).perform();
	}

	public void moveMouseToCenter() {
		int windowWidth = driver.manage().window().getSize().getWidth();
		int windowHeight = driver.manage().window().getSize().getHeight();

		Actions actions = new Actions(driver);
		actions.moveByOffset(windowWidth / 2 - toggleAside.getLocation().getX(),
				windowHeight / 2 - toggleAside.getLocation().getY()).perform();

		/*
		 * new WebDriverWait(driver, Duration.ofSeconds(5))
		 * .until(ExpectedConditions.attributeContains(toggleAside, "class",
		 * "retracted"));
		 */
	}

	public void clickMenuRelations() {
		menuRelations.click();
	}

	public void clickLinkPortfolios() {
		linkPortfolios.click();
	}
}
