package org.example.classes.rooms.cells;

import org.example.classes.rooms.Coordinates;

public class PlayerCell implements Cell {
    private Coordinates coordinates;

    public PlayerCell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String printIcon() {
        return "@";
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
