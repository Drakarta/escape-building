
package org.example.utils;

import java.util.List;
import java.util.Map;

import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.cells.PlayerCell;
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
        Map<String, String> row = result.get(0);

        // Build a Player object


        // Optional: set player ID if needed
        // player.setId(Integer.parseInt(row.get("id")));

        // Set the player in the singleton
        CurrentUser.getInstance().setCurrentPlayer(new Player(1, row.get("name"), row.get("username"), Integer.parseInt(row.get("hp")), row.get("currentRoom"), new PlayerCell(new Coordinates(1, 1))));
        return true;
    }
}
