package com.q4tech.WebAppTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardView {
	private WebDriver driver;

	// Localizadores Elementos web
	@FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/*[1]")
	@CacheLookup
	WebElement toggleAside;

	// User Button	
	@FindBy(xpath = "//span[@class='btn-label text-break']")
	@CacheLookup
	WebElement btnUser;

	// Logout Button	
	@FindBy(id = "btnLogout")
	@CacheLookup
	WebElement btnLogout;

	// Menu Portfolios
	@FindBy(xpath = "//span[@id='menu_relations']")
	@CacheLookup
	WebElement menuRelations;

	// Grupo de carteras Physicians
	@FindBy(xpath = "//a[@id='menu_relations_5']")
	WebElement linkPortfoliosPhysicians;
	
	// Grupo de carteras Clinical Sites
	@FindBy(xpath = "//a[@id='menu_relations_9']")
	WebElement linkPortfoliosClinicalSites;

	// Constructor
	public DashboardView(WebDriver driver) {
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

	public void clickLinkPortfoliosPhysicians() {
		linkPortfoliosPhysicians.click();
	}
	
	public void clickLinkPortfoliosClinicalSites() {
		linkPortfoliosClinicalSites.click();
	}

	public void doLogOut() {
		this.mouseOverToggleAside();
		btnUser.click();
		btnLogout.click();
	}
}
