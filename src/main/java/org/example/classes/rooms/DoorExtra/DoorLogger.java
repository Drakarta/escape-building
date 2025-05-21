package org.example.classes.rooms.DoorExtra;

public class DoorLogger implements DoorObserver {
    private final String doorName;

    public DoorLogger(String doorName) {
        this.doorName = doorName;
    }

    @Override
    public void onDoorStateChanged(boolean isLocked) {
        System.out.println("[" + doorName + "] Door is now " + (isLocked ? "locked" : "unlocked"));
    }
}
