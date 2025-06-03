package org.example.classes.rooms;

import org.example.classes.rooms.cells.Cell;
import org.example.classes.rooms.cells.DoorCell;

public class UnlockDoors {
    public UnlockDoors(RoomLayout room){
        for (int y = 0; y < room.getRoomLayout().size(); y++) {
            for (int x = 0; x < room.getRoomLayout().get(y).size(); x++) {
                Cell cell = room.getCell(x, y);
                if (cell instanceof DoorCell) {
                    ((DoorCell) cell).unlock();
                }
            }
        }
        System.out.println("All doors have been unlocked.");
    }

}
