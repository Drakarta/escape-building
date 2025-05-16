package org.example.classes.rooms.cells;

public class EmptyCell implements Cell {
    @Override
    public String printIcon() {
        return " ";
    }

    @Override
    public boolean isWalkable() {
        return true;
    }
}