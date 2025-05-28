package org.example.classes.jokers;

import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.cells.Cell;
import org.example.classes.rooms.cells.DoorCell;

public class KeyJoker extends Joker {
    @Override
    public void useJoker(RoomTemplate room) {
        if (room.getDescription().equalsIgnoreCase("This is room 1") || room.getDescription().equalsIgnoreCase("Review")){
            RoomLayout roomLayout = room.getRoomLayout();
            for (int y = 0; y < roomLayout.getRoomLayout().size(); y++) {
                for (int x = 0; x < roomLayout.getRoomLayout().get(y).size(); x++) {
                    Cell cell = roomLayout.getCell(x, y);
                    if (cell instanceof DoorCell) {
                        ((DoorCell) cell).unlock();
                    }
                }
            }
            System.out.println("Doors have been unlocked");
        } else {
            System.out.println("Cant use this joker here!");
        }
    }
}