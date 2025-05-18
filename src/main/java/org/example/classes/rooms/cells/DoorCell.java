package org.example.classes.rooms.cells;

import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTypes;

public class DoorCell implements Cell {
    private boolean isLocked;
    private final RoomTypes toRoom;

    public DoorCell(boolean isLocked, RoomTypes toRoom) {
        this.isLocked = isLocked;
        this.toRoom = toRoom;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlock() {
        isLocked = false;
    }

    public void lock() {
        isLocked = true;
    }

    public RoomTypes getToRoom() {
        return toRoom;
    }

    @Override
    public String printIcon() {
        return "D";
    }

    @Override
    public boolean isWalkable() {
        if (isLocked) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    @Override
    public void interact(PlayerCell player, RoomLayout room) {
        if (isLocked) {
            System.out.println("The door is locked.");
        } else {
            System.out.println("The door is open. You may pass.");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
