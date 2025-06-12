package org.example.utils;

import org.example.classes.Player;
import org.example.classes.singleton.CurrentUser;

public class Save {
    public static void saveGame() {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Player current = CurrentUser.getInstance().getCurrentPlayer();

        try {
            if (current != null) {
                hibernateUtil.update(current);
                System.out.println("Game saved successfully for player: " + current.getUsername());
            } else {
                System.out.println("No player is currently logged in. Cannot save game.");
            }
        } catch (Exception e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }
}
