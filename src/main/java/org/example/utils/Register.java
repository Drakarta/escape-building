package org.example.utils;

import org.example.classes.Player;
import org.example.classes.singleton.CurrentUser;

public class Register {
    private HibernateUtil hibernateUtil;

    public Register(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    public boolean register(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return false;
        }

        Object existingUser = null;
        try {
            existingUser = hibernateUtil.read("FROM Player WHERE username =" + username, Player.class, true);
        } catch (Exception e) {
            return false;
        }

        if (existingUser != null) {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }

        Player newPlayer = new Player(username, password);
        hibernateUtil.create(newPlayer);
        System.out.println("User registered successfully: " + username);

        CurrentUser.getInstance().setCurrentPlayer(newPlayer);
        return true;
    }
}

