package org.example.tests.stubs;

import org.example.classes.Player;
import org.example.utils.HibernateUtil;

public class HibernateUtilStubLogin extends HibernateUtil {
    public Player testPlayer;

    @Override
    public Object read(String query, Class clazz, boolean singleResult) {
        return testPlayer;
    }
}
