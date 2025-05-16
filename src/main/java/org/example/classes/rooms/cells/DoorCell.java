package org.example.classes.rooms.cells;

import org.example.classes.rooms.RoomTypes;

public class DoorCell implements Cell {
    private Boolean isLocked;
    private RoomTypes toRoom;

    public DoorCell(Boolean isLocked, RoomTypes toRoom) {
        this.isLocked = isLocked;
        this.toRoom = toRoom;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public RoomTypes getToRoom() {
        return toRoom;
    }

    @Override
    public String printIcon() {
        return "D";
    }
}
