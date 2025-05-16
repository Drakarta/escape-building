package org.example;

import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.cells.PlayerCell;

public class Main {
    public static void main(String[] args) {
        RoomLayout room = new RoomLayout(8, 8, "Question");  
        room.printRoomLayout(new PlayerCell(new Coordinates(2, 2)));
    }
}