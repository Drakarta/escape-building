package org.example.utils;

import org.example.classes.singleton.CurrentUser;
import org.example.classes.Player;

public class Login {
    private HibernateUtil hibernateUtil;

    public Login(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    public boolean login(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return false;
        }
        
        try {
            Player player = (Player) hibernateUtil.read("FROM Player WHERE username = '" + username + "'", Player.class, true);
            if (player == null) {
                System.out.println("Username does not exist. Please register first.");
                return false;
            }
            System.out.println("Player found: " + player.getUsername());
            if (!player.getPassword().equals(password)) {
                System.out.println("Incorrect password. Please try again.");
                return false;
            }
            System.out.println(player.getPassword());
            CurrentUser.getInstance().setCurrentPlayer(player);
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            return false;
        }
        return true;
    }
}
