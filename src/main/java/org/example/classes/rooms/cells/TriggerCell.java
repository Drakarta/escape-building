package org.example.classes.rooms.cells;

import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;

public class TriggerCell implements Cell {
    public enum TriggerType {
        MESSAGE
    }

    private final TriggerType type;
    private final String data; 
    private boolean triggered;
    private final Coordinates coordinates;

    public TriggerCell(TriggerType type, String data, int x, int y) {
        this.type = type;
        this.data = data;
        this.triggered = false;
        this.coordinates = new Coordinates(x, y);
    }
    
    @Override
    public String printIcon() {
        return " ";
    }

    public void stepOnTrigger(PlayerCell player, RoomLayout room) {
        if (triggered) return;

        switch (type) {
            case MESSAGE -> System.out.println(data);
        }

        triggered = true;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
