package org.example.utils;

import java.util.List;
import java.util.Map;

import org.example.classes.singleton.CurrentUser;
import org.example.classes.Player;

public class Login {

    public static boolean login(String username, String password) {
        // WARNING: This is still vulnerable to SQL injection
        String query = "SELECT * FROM player WHERE username = '" + username + "' AND password = '" + password + "'";

        List<Map<String, String>> result = (List<Map<String, String>>) DatabaseConnection.execute(query);

        if (result.isEmpty()) {
            System.out.println("Invalid username or password.");
            return false;
        }

        // Get the first result row
        Map<String, String> row = result.getFirst();


        CurrentUser.getInstance().setCurrentPlayer(new Player(Integer.parseInt(row.get("id")), row.get("name"), row.get("username"), Integer.parseInt(row.get("hp")), row.get("currentRoom")));
        return true;
    }
}
