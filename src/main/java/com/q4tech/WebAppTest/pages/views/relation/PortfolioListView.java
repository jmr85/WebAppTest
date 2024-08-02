package com.q4tech.WebAppTest.pages.views.relation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.q4tech.WebAppTest.pages.BaseView;
public class PortfolioListView extends BaseView {
	// Localizadores Elementos web

	// Item de cartera
	// @FindBy(xpath =
	// "/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[5]/div/div[2]")
	//@FindBy(xpath = "//strong[contains(text(),'ALFANO, AGOSTINO')]")
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[5]/div/div[2]")
	WebElement itemPortfolio;

	// boton acciones del relation, de filtro y demas
	@FindBy(xpath = "//button[@id='dropdownActions']")
	WebElement dropdownActions;
	
	// boton ver detalle cartera
	@FindBy(xpath = "//button[text()=' View Portfolio']")
	@CacheLookup
	WebElement btnViewPortfolio;
	
	// boton Add Portfolio / New Portfolio
	@FindBy(xpath = "//button[@class=\"btn btn-sm btn-primary\"][normalize-space()=\"Add Portfolio\"]")
	@CacheLookup
	WebElement btnAddPortfolio;
	
	// Constructor
	public PortfolioListView(WebDriver driver) {
		super(driver);
	}

	// Acciones
	public void clickItemPortfolio() {
		click(itemPortfolio);
	}

	public void clickdropdownActions() {
		click(dropdownActions);
	}

	public void clickViewPortfolio() {
		click(btnViewPortfolio);
	}
	
	public void clickAddPortfolio() {
		click(btnAddPortfolio);
	}	

	public void doViewPortfolio() {
		clickItemPortfolio();
		clickViewPortfolio();
	}
	
	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(PortfolioListView.class);
	}
}