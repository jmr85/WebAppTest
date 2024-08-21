package com.q4tech.WebAppTest.pages.views.xserver.user;

import java.security.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.pages.BaseView;

public class UserListView extends BaseView {

    // Input Text Name Filter xServer
	@FindBy(xpath = "(//input[@placeholder='Filter'])[2]")
	WebElement txtNameFilter;

	// checkbox userItem xserver grilla
	@FindBy(xpath = "(//div[@role='checkbox'])[2]")
	WebElement checkBoxUserItem;
	
	// Dropdown Actions
	@FindBy(css = "div:nth-child(5) > #dropdownOutgoing")
	WebElement btnActions;

	@FindBy(xpath = "//a[contains(text(),'Generate Pin')]")
	WebElement optionGeneratePIN;

    // Modal de confirmacion, Yes
    @FindBy(css = ".btn-success")
	WebElement btnYes;

    // Constructor
    public UserListView(WebDriver driver) {
        super(driver);
    }

    // Acciones
    public void doGeneratePIN() throws InterruptedException {
        clickWithJS(txtNameFilter);
        sendKeys(txtNameFilter, "jr");
        sendKeys(txtNameFilter, Keys.ENTER);

        clickWithJS(checkBoxUserItem);
        clickWithJS(btnActions);
        clickWithJS(optionGeneratePIN);

        Thread.sleep(10000);
        clickWithJS(btnYes);
    }

    @Override
    protected Logger getLogger() {
        return LoggerFactory.getLogger(UserListView.class);
    }
}
