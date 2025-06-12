package org.example.classes.singleton;

import org.example.classes.rooms.DoorLink;
import org.example.classes.rooms.cells.DoorCell;

import java.util.ArrayList;
import java.util.List;

public class DoorList {
    private static volatile DoorList instance;
    private final List<DoorLink> doorLinks = new ArrayList<>();

    // Private constructor prevents instantiation from outside
    public DoorList() {}

    // Thread-safe Singleton accessor
    public static DoorList getInstance() {
        if (instance == null) {
            synchronized (DoorList.class) {
                if (instance == null) {
                    instance = new DoorList();
                }
            }
        }
        return instance;
    }

    public void addDoor(String sourceRoom, String targetRoom, DoorCell door) {
        doorLinks.add(new DoorLink(sourceRoom, targetRoom, door));
    }

    public DoorCell findDoor(String sourceRoom, String targetRoom) {
        for (DoorLink link : doorLinks) {
            if (link.getSourceRoom().equals(sourceRoom) && link.getTargetRoom().equals(targetRoom)) {
                return link.getDoor();
            }
        }
        return null;
    }

    public List<DoorLink> getAllDoorLinks() {
        return doorLinks;
    }
}
