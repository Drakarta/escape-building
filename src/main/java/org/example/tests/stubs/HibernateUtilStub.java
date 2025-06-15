package org.example.tests.stubs;

import org.example.classes.Player;
import org.example.utils.*;

public class HibernateUtilStub extends HibernateUtil {
    public boolean simulateUserExists = false;
    public boolean createWasCalled = false;

    @Override
    public Object read(String query, Class clazz, boolean singleResult) {
        if (simulateUserExists) {
            return new Player("existingUser", "password");
        }
        return null;
    }

    @Override
    public void create(Object entity) {
        createWasCalled = true;
        System.out.println("[Stub] Simulated database insert: " + entity);
    }
}
