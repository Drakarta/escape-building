package org.example;

import org.example.classes.rooms.RoomList;
import org.example.classes.rooms.subclasses.TestRoom;
import org.example.classes.rooms.subclasses.TestRoom2;

public class Main {
    public static void main(String[] args) {
        RoomList rooms = RoomList.getInstance();
        rooms.addRoom(new TestRoom());
        rooms.addRoom(new TestRoom2());
        rooms.getRoomList().get(0).play(0);
    }
}