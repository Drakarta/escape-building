package org.example;

import org.example.classes.Player;

public class CurrentUser {
    private static CurrentUser instance;

    private Player currentUser;

    public CurrentUser() {

    }

    public static CurrentUser getInstance() {
        if (instance == null) {
            synchronized (CurrentUser.class) {
                if (instance == null) {
                    instance = new CurrentUser();
                }
            }
        }
        return instance;
    }

    public void setCurrentPlayer(Player player) {
        this.currentUser = player;
    }

    public Player getCurrentPlayer() {
        return this.currentUser;
    }
}
