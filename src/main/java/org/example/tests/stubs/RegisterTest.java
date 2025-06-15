package org.example.tests.stubs;

import org.example.utils.Register;

public class RegisterTest {
    public static void main(String[] args) {
        HibernateUtilStub stub = new HibernateUtilStub();

        // Simulate new user scenario
        Register registerService = new Register(stub);
        boolean result = registerService.register("testuser", "1");

        if (result && stub.createWasCalled) {
            System.out.println("Test passed: user registered successfully.");
        } else {
            System.out.println("Test failed: user was not registered.");
        }

        // simulate existing user scenario
        stub.simulateUserExists = true;
        result = registerService.register("existingUser", "1");

        if (!result) {
            System.out.println("Test passed: registration blocked for existing user.");
        } else {
            System.out.println("Test failed: registration should have failed.");
        }
    }
}
