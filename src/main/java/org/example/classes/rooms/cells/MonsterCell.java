package org.example.classes.rooms.cells;

import org.example.classes.rooms.Coordinates;

public class MonsterCell implements Cell {
    private Coordinates coordinates;

    public MonsterCell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String printIcon() {
        return "&";
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates.setX(x);
        this.coordinates.setY(y);
    }

}
