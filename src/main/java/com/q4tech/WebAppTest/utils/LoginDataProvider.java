package com.q4tech.WebAppTest.utils;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.q4tech.WebAppTest.utils.JsonConfigReader.User;

public class LoginDataProvider {

    @DataProvider(name = "loginDataProvider")
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
