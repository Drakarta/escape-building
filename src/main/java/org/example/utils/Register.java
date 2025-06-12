package org.example.utils;

public class Register {

    public static boolean register(String username, String password) {
        // Here you would typically check if the username already exists
        // and then save the new user to a database or a file.
        // For simplicity, we will just print the registration details.

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return false;
        }


        System.out.println("User registered successfully: " + username);
        return true;
    }
    
}
