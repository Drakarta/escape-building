package org.example.classes.singleton;

import java.util.ArrayList;
import java.util.List;

import org.example.classes.rooms.RoomTemplate;

public class RoomList {
    private static volatile RoomList instance;
    private final List<RoomTemplate> rooms = new ArrayList<>();

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

    public synchronized void addRoom(RoomTemplate room) {
        rooms.add(room);
    }

    public synchronized void removeRoom(RoomTemplate room) {
        rooms.remove(room);
    }

    public List<RoomTemplate> getRoomList() {
        return List.copyOf(rooms);
    }

    public RoomTemplate get(int index) {
        return rooms.get(index);
    }

    public RoomTemplate getRoomByName(String name) {
        for (RoomTemplate room : rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }
}
