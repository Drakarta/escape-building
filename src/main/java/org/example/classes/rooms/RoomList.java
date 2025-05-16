package org.example.classes.rooms;

import java.util.ArrayList;
import java.util.List;

public class RoomList {
    private static volatile RoomList instance;
    private final List<RoomTypes> rooms = new ArrayList<>();

    private RoomList() {
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
