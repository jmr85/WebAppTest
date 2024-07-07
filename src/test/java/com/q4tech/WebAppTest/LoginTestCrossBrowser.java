package com.q4tech.WebAppTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.pages.*;

public class LoginTestCrossBrowser {
	String url = "http://capital.q4tech.com:7272/sfNetWebApp.Web_acmeus/";
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String navegador) {
		if (navegador.equalsIgnoreCase("Chrome")) {
			// Acciones para abrir el navegador Chrome	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			
			driver = new ChromeDriver(options);
		} else if (navegador.equalsIgnoreCase("Edge")) {
			// Acciones para abrir el navegador Edge
			driver = new EdgeDriver();
		} else if (navegador.equalsIgnoreCase("Firefox")) {
			// Acciones para abrir el navegador Firefox
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void login() {
		// 1) Hacer clic en Sign In
		// 2) Completar el correo y contraseña
		LoginView login = new LoginView(driver);
		login.ingresarCredenciales("admin", "admin2024");
	}

	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
