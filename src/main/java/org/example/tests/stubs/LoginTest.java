package org.example.tests.stubs;

import org.example.classes.Player;
import org.example.utils.Login;

public class LoginTest {
    public static void main(String[] args) {
        // Simulate a valid login
        HibernateUtilStubLogin stub = new HibernateUtilStubLogin();
        stub.testPlayer = new Player("testuser", "1234");

        Login login = new Login(stub);
        boolean success = login.login("testuser", "1234");

        if (success) {
            System.out.println("Login success test passed.");
        } else {
            System.out.println("Login success test failed.");
        }

        // Simulate incorrect password
        stub.testPlayer = new Player("testuser", "wrongpass");
        boolean fail = login.login("testuser", "1234");

        if (!fail) {
            System.out.println("Incorrect password test passed.");
        } else {
            System.out.println("Incorrect password test failed.");
        }

        // Simulate user not found
        stub.testPlayer = null;
        boolean noUser = login.login("unknown", "1234");

        if (!noUser) {
            System.out.println("User not found test passed.");
        } else {
            System.out.println("User not found test failed.");
        }
    }
}
