package com.q4tech.WebAppTest;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.q4tech.WebAppTest.listeners.TestListener;
import com.q4tech.WebAppTest.pages.*;
import com.q4tech.WebAppTest.utils.JsonConfigReader;
import com.q4tech.WebAppTest.utils.JsonConfigReader.User;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

	@Test(priority = 0, dataProvider = "loginData", description = "Valid Login Scenario with correct username and password.")
	public void login(String username, String password) throws InterruptedException, IOException {
		
		LoginView login = new LoginView(driver);
		DashboardView dashboard = login.doLogin(username, password);

		Thread.sleep(500);

		logger.info("Credentials entered");

		getScreenshot("2_postLogin");

		logger.info("Navigating to dashboard");
		dashboard.doLogOut();
		logger.info("Logout completed");

		getScreenshot("3_postLogout");

		Thread.sleep(1000);
	}

	@Test(enabled = false)//No tiene DataProvider
	public void login() throws IOException, InterruptedException {
		LoginView login = new LoginView(driver);

		getScreenshot("1_preLogin");

		DashboardView dashboard = login.doLogin("admin", "admin2024");
		
		Thread.sleep(1000);

		logger.info("Navigating to dashboard");
		dashboard.doLogOut();
		logger.info("Logout completed");
		
		Thread.sleep(3000);

		getScreenshot("2_postLogin");
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
}
