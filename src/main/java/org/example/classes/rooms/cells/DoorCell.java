package org.example.classes.rooms.cells;

import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.DoorExtra.*;

import java.util.ArrayList;
import java.util.List;

public class DoorCell implements Cell {
    private boolean isLocked;
    private final List<DoorObserver> observers = new ArrayList<>();

    public DoorCell(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlock() {
        isLocked = false;
        notifyObservers();
    }

    public void lock() {
        isLocked = true;
        notifyObservers();
    }

    public void addObserver(DoorObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DoorObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (DoorObserver observer : observers) {
            observer.onDoorStateChanged(isLocked);
        }
    }

    @Override
    public String printIcon() {
        return "D";
    }

    @Override
    public boolean isWalkable() {
        return !isLocked;
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
