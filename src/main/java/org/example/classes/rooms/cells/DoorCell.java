package org.example.classes.rooms.cells;

public class DoorCell implements Cell {
    private Boolean isLocked;
    private String doorPosition;
    private String toRoomID;

    public DoorCell(Boolean isLocked, String doorPosition, String toRoom) {
        this.isLocked = isLocked;
        this.doorPosition = doorPosition;
        this.toRoomID = toRoom;
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

    public String getToRoom() {
        return toRoomID;
    }

    public String getDoorPosition() {
        return doorPosition;
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
    public boolean isDoor() {
        return true;
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    public void interact() {
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
