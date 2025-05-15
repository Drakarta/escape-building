package org.example.classes.rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.example.classes.DatabaseConnection;
import org.example.classes.RoomTypes;

public class RoomList {
    private static volatile RoomList instance;
    private final List<RoomTypes> rooms = new ArrayList<>();

    private RoomList() {
        List<Map<String, String>> rows = DatabaseConnection.query("SELECT * FROM Room;");
        for (Map<String, String> row : rows) {
            int id = Integer.parseInt(row.get("id"));
            String name = row.get("name");
            String description = row.get("description");
            boolean isLocked = Boolean.parseBoolean(row.get("isLocked"));
            String questionCategory = row.get("questionCategory");
            ArrayList<ArrayList<String>> roomLayout = new ArrayList<>();

            RoomTypes room = new RoomTypes(id, name, description, isLocked, questionCategory, roomLayout);
            addRoom(room);
        }

    }

    public static RoomList getInstance() {
        if (instance == null) {
            synchronized (RoomList.class) {
                if (instance == null) {
                    instance = new RoomList();
                }
            }
        }
        return instance;
    }

    public synchronized void addRoom(RoomTypes room) {
        rooms.add(room);
    }

    public synchronized void removeRoom(RoomTypes room) {
        rooms.remove(room);
    }

    public List<RoomTypes> getRoomList() {
        return List.copyOf(rooms);
    }
}
