package org.example.classes.rooms;

import org.example.classes.singleton.CurrentUser;
import org.example.utils.DatabaseConnection;

import java.util.List;
import java.util.Map;

public class RoomLoader {
    private static RoomLoader instance;
    private RoomLoader() {}

    public static synchronized RoomLoader getInstance() {
        if(instance == null){
            instance = new RoomLoader();
        }
        return instance;
    }

    public String getCurrentDatabaseRoom() {
        String query = "SELECT currentRoom from Player WHERE username = '" + CurrentUser.getInstance().getCurrentPlayer().getUsername() + "'";
        DatabaseConnection.execute(query);

        List<Map<String, String>> result = (List<Map<String, String>>) DatabaseConnection.execute(query);

        Map<String, String> row = result.getFirst();

        System.out.println(row.get("currentRoom"));
        return row.get("currentRoom");
    }
}
