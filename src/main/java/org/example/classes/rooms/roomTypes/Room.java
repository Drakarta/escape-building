package org.example.classes.rooms.roomTypes;

import java.util.Scanner;

import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.cells.PlayerCell;

public class Room extends RoomTemplate {
    public Room(int id, String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        super(id, name, description, isLocked, questionCategory, roomLayout);
    }

    @Override
    public void displayRoom() {
        System.out.println(getName());
        getRoomLayout().printRoomLayout(new PlayerCell(new Coordinates(2, 2)));
    }

    @Override
    public void question() {
        
    }
}
