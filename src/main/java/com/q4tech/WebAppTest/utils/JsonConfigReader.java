package com.q4tech.WebAppTest.utils;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for reading and accessing configuration data from a JSON file.
 * This class provides methods to retrieve various configuration settings
 * such as base URL, evidence directory, and user information.
 */
public class JsonConfigReader {
    private static JSONObject config;

    static {
        try {
            InputStream inputStream = JsonConfigReader.class.getClassLoader().getResourceAsStream("config.json");
            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            config = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the base URL from the configuration.
     *
     * @return the base URL as a String
     */
    public static String getBaseUrl() {
        return config.getJSONObject("TestConfig").getString("BaseUrl");
    }

    /**
     * Retrieves the evidence directory path from the configuration.
     *
     * @return the evidence directory path as a String
     */
    public static String getEvidenceDirectory() {
        return config.getJSONObject("TestConfig").getString("EvidenceDirectory");
    }

    /**
     * Retrieves a list of all users from the configuration.
     *
     * @return a List of User objects
     */
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        JSONArray usersArray = config.getJSONObject("TestConfig").getJSONArray("Users");
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userJson = usersArray.getJSONObject(i);
            User user = new User(
                userJson.getInt("Code"),
                userJson.getString("Name"),
                userJson.getString("UserName"),
                userJson.getString("Password")
            );
            users.add(user);
        }
        return users;
    }

    /**
     * Retrieves a specific user by their username.
     *
     * @param username the username to search for
     * @return the User object if found, null otherwise
     */
    public static User getUserByUsername(String username) {
        for (User user : getUsers()) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Inner class representing a User with their associated details.
     */
    public static class User {
        private int code;
        private String name;
        private String userName;
        private String password;

        /**
         * Constructs a new User with the given details.
         *
         * @param code the user's code
         * @param name the user's name
         * @param userName the user's username
         * @param password the user's password
         */
        public User(int code, String name, String userName, String password) {
            this.code = code;
            this.name = name;
            this.userName = userName;
            this.password = password;
        }

        /**
         * @return the user's code
         */
        public int getCode() { return code; }

        /**
         * @return the user's name
         */
        public String getName() { return name; }

        /**
         * @return the user's username
         */
        public String getUserName() { return userName; }

        /**
         * @return the user's password
         */
        public String getPassword() { return password; }
    }
}
