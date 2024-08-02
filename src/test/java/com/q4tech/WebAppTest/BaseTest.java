package com.q4tech.WebAppTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.listeners.TestListener;
import com.q4tech.WebAppTest.utils.CaptureEvidence;
import com.q4tech.WebAppTest.utils.JsonConfigReader;

@Listeners(TestListener.class)
public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    //el @Optional("Chrome") ejecuta test con Chrome si no le pasamos param desde testng.xml
    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String navegador) {
        if (navegador.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (navegador.equalsIgnoreCase("Edge")) {
            //EdgeOptions options = new EdgeOptions();
			//options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Safari/605.1.15");
			//driver = new EdgeDriver(options);
            driver = new EdgeDriver();
        } else if (navegador.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        
        driver.get(JsonConfigReader.getBaseUrl());
        logger.info("Navigated to URL: {}", JsonConfigReader.getBaseUrl());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("tearDown");
        }
    }

    public void getScreenshot(String nombreBase) throws IOException {
        String fileName = CaptureEvidence.getScreenshot(driver, JsonConfigReader.getEvidenceDirectory(), nombreBase);
		logger.info("Screenshot captured: {}", fileName);
	}
}