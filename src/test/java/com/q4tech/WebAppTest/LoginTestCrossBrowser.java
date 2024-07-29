package com.q4tech.WebAppTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.listeners.TestListener;
import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.utils.CaptureEvidence;
import com.q4tech.WebAppTest.utils.JsonConfigReader;
import com.q4tech.WebAppTest.utils.JsonConfigReader.User;

@Listeners(TestListener.class)
public class LoginTestCrossBrowser {
	private static final Logger logger = LoggerFactory.getLogger(LoginTestCrossBrowser.class);

	WebDriver driver;
	
	//el @Optional("Chrome") ejecuta test con Chrome si no le pasamos param desde testng.xml
	@BeforeTest
	@Parameters("browser")
	public void setup(@Optional("Chrome") String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			// Acciones para abrir el navegador Chrome	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("Edge")) {
			// Acciones para abrir el navegador Edge
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			// Acciones para abrir el navegador Firefox
			driver = new FirefoxDriver();
		}
		
		driver.get(JsonConfigReader.getBaseUrl());
		logger.info("Navigated to URL: {}", JsonConfigReader.getBaseUrl());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(priority = 0, dataProvider = "loginData", description = "Valid Login Scenario with correct username and password.")
	public void login(String username, String password) throws InterruptedException, IOException {
		
		LoginView login = new LoginView(driver);
		login.doLogin(username, password);

		Thread.sleep(500);

		String fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), "postLogin");
		logger.info("Screenshot captured: {}", fileName);

		logger.info("Credentials entered");

		DashboardView dashboard = new DashboardView(driver);
		logger.info("Navigating to dashboard");
		dashboard.doLogOut();
		logger.info("Logout completed");

		Thread.sleep(1000);
	}

	@DataProvider(name = "loginData")
    public Object[][] loginData() {
        List<User> users = JsonConfigReader.getUsers();
        Object[][] data = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i).getUserName();
            data[i][1] = users.get(i).getPassword();
        }
        return data;
    }

	@AfterSuite
	public void cerrarNavegador() {
		driver.quit();
		logger.info("tearDown");
	}
}
