package org.example.classes.singleton;

import org.example.classes.rooms.RoomTemplate;

public class CurrentRoom {
    private static CurrentRoom instance;

    private RoomTemplate room;

    private CurrentRoom() {

    }

    public static CurrentRoom getInstance() {
        if (instance == null) {
            synchronized (CurrentRoom.class) {
                if (instance == null) {
                    instance = new CurrentRoom();
                }
            }
        }
        return instance;
    }

    public void setCurrentRoom(RoomTemplate room) {
        this.room = room;
    }

    public RoomTemplate getCurrentRoom() {
        return this.room;
    }
}
