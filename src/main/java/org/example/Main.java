package org.example;

import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.TestRoom;
import org.example.classes.rooms.cells.PlayerCell;

public class Main {
    public static void main(String[] args) {
        TestRoom room = new TestRoom();
        room.play();
    }
}