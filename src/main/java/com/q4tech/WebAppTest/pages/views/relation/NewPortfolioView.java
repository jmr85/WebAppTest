package com.q4tech.WebAppTest.pages.views.relation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.pages.BaseView;

public class NewPortfolioView extends BaseView {
	/*
	 * @FindAll ubica el elemento web utilizando más de un criterio, 
	 * siempre que coincida al menos un criterio. A diferencia de @FindBys, 
	 * utiliza una  relación condicional OR entre los múltiples @FindBy.
	 * */
	@FindAll({
		@FindBy(xpath="//*[@id=\"kt_toolbar_container\"]/div[2]/button"),
		@FindBy(xpath = "//button[contains(@class, 'btn-primary')]/i[contains(@class, 'fa-save')]"),
		@FindBy(xpath = "//button[@ng-click=\"save()\"]"),
		@FindBy(css = ".btn.btn-sm.btn-primary[ng-click=\"save()\"]")
	})
	@CacheLookup
	WebElement btnSaveNewPortfolio;
	
	// Customer Selection HCP
	@FindBy(xpath = "//button[contains(@class, 'btn-secondary')]//i[contains(@class, 'fa-ellipsis-h')]")
	@CacheLookup
	WebElement btnSelectCustomer;
	
	//Search Customer dentro del Modal
	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	@CacheLookup
	WebElement searchCustomer;
	
	// Search Customer Button
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	@CacheLookup
	WebElement btnSearchCustomer;
	
	/*
	 * @FindAll ubica el elemento web utilizando más de un criterio, 
	 * siempre que coincida al menos un criterio. A diferencia de @FindBys, 
	 * utiliza una  relación condicional OR entre los múltiples @FindBy.
	 * */
	// Seleccion de customer luego del search
	@FindAll({
		@FindBy(xpath = "div[id='1720645889016-2-uiGrid-000H-cell']"),
		@FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]"),	
		@FindBy(css = "body > div:nth-child(74) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
	})
	WebElement selectLinkCustomer;
	
	//Specialty:
	@FindBy(xpath = "//label[text()='Specialty:']/following-sibling::div//span[contains(@class, 'ui-select-toggle')]")
	@CacheLookup
	WebElement selectSpecialty;
	
	//@FindBy(xpath = "//ul[contains(@class, 'ui-select-choices')]//div[contains(@class, 'ui-select-choices-row')]")
	//WebElement specialtyOptions;
	
	// 3-0 selecciona a CRITICAL CARE SURGERY (el primero)
	// 3-1 selecciona a ALLERGY (el segundo)
	//@FindBy(xpath = "//*[@id=\"ui-select-choices-row-3-0\"]/span/span")
	//WebElement specialtySelectChoice;
	
	//Samples Allowed:
	@FindBy(xpath = "(//span[@aria-label='Select box activate'])[5]")
	@CacheLookup
	WebElement selectSamplesAllowed;
	
	public NewPortfolioView(WebDriver driver) {
		super(driver);
	}
	
	public void clickBtnSelectCustomer() {
		click(btnSelectCustomer);
	}
	
	public void clickBtnSaveNewPortfolio() {
		click(btnSaveNewPortfolio);
	}
	
	public void searchCustomer(String nameCustomer) {
		sendKeys(searchCustomer, nameCustomer);
		click(btnSearchCustomer);
	}
	
	public void clickLinkCustomer() {
		click(selectLinkCustomer);
	}
	
	public void selectSpecialty(String specialtyName) {
	    // Abrir el dropdown
		click(selectSpecialty);
	    //selecciona a CRITICAL CARE SURGERY (el primero)
	    //specialtySelectChoice.click();
	    
	    String xpath = String.format("//span[contains(text(),'%s')]", specialtyName);
        driver.findElement(By.xpath(xpath)).click();
	    
	}
	
	// "Yes" / "No"
	public void selectSamplesAllowed(String samplesAllowedName) {
	    // Abrir el dropdown
		click(selectSamplesAllowed);
	    //selecciona a CRITICAL CARE SURGERY (el primero)
	    //specialtySelectChoice.click();
	    
	    String xpath = String.format("//span[contains(text(),'%s')]", samplesAllowedName);
        driver.findElement(By.xpath(xpath)).click();
	}

	@Override
	protected Logger getLogger() {
		return LoggerFactory.getLogger(NewPortfolioView.class);
	}
}
