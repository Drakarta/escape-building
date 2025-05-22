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

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
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
}
