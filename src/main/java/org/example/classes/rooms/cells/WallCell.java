package org.example.classes.rooms.cells;

public class WallCell implements Cell {
    @Override
    public String printIcon() {
        return "#";
    }

    @Override
    public boolean isWalkable() {
        return false;
    }
}
