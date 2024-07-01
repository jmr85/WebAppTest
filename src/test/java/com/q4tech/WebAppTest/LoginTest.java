package com.q4tech.WebAppTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.q4tech.WebAppTest.pages.*;

public class LoginTest {
	String url = "http://capital.q4tech.com:7272/sfNetWebApp.Web_acmeus/";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		// 1) Hacer clic en Sign In
		// 2) Completar el correo y contraseña
		LoginPage login = new LoginPage(driver);
		login.ingresarCredenciales("admin", "admin2024");
	}

	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
