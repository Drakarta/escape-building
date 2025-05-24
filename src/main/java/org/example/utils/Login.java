// package org.example.utils;

// import java.util.List;
// import java.util.Map;

// import org.example.CurrentUser;
// import org.example.classes.Player;

// public class Login {

//     public static boolean login(String username, String password) {
//         // WARNING: This is still vulnerable to SQL injection
//         String query = "SELECT * FROM player WHERE username = '" + username + "' AND password = '" + password + "'";

//         List<Map<String, String>> result = (List<Map<String, String>>) DatabaseConnection.execute(query);

//         if (result.isEmpty()) {
//             System.out.println("Invalid username or password.");
//             return false;
//         }

//         // Get the first result row
//         Map<String, String> row = result.get(0);

//         // Build a Player object
//         Player player = new Player();
//         player.setName(row.get("name"));
//         player.setUsername(row.get("username"));

//         try {
//             String hpStr = row.get("hp");
//             String roomStr = row.get("currentRoom");

//             if (hpStr != null && !hpStr.isEmpty()) {
//                 player.setHp(Integer.parseInt(hpStr));
//             } else {
//                 System.out.println("Warning: HP is missing or null.");
//                 player.setHp(100); // or some sensible default
//             }

//             if (roomStr != null && !roomStr.isEmpty()) {
//                 player.setCurrentRoom(roomStr);
//             } else {
//                 System.out.println("Warning: Current room is missing or null.");
//                 player.setCurrentRoom("No room assigned"); // or another default
//             }

//         } catch (NumberFormatException e) {
//             System.out.println("Error parsing numeric fields: " + e.getMessage());
//             return false;
//         }

//         // Optional: set player ID if needed
//         // player.setId(Integer.parseInt(row.get("id")));

//         // Set the player in the singleton
//         CurrentUser.getInstance().setCurrentPlayer(player);
//         return true;
//     }
// }
