package org.example.classes.rooms;

import org.example.classes.rooms.cells.DoorCell;

public class DoorLink {
    private final String sourceRoom;
    private final String targetRoom;
    private final DoorCell door;

    public DoorLink(String sourceRoom, String targetRoom, DoorCell door) {
        this.sourceRoom = sourceRoom;
        this.targetRoom = targetRoom;
        this.door = door;
    }

    public String getSourceRoom() {
        return sourceRoom;
    }

    public String getTargetRoom() {
        return targetRoom;
    }

    public DoorCell getDoor() {
        return door;
    }
}
