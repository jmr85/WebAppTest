package com.q4tech.WebAppTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.q4tech.WebAppTest.listeners.TestListener;
import com.q4tech.WebAppTest.utils.JsonConfigReader;

@Listeners(TestListener.class)
public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("Chrome") String navegador) {
        if (navegador.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (navegador.equalsIgnoreCase("Edge")) {
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
    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}