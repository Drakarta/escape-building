package org.example.classes.rooms.cells;

import org.example.classes.rooms.Coordinates;
import org.example.utils.PlayerCellConverter;
import jakarta.persistence.Convert;

public class PlayerCell implements Cell {
    @Convert(converter = PlayerCellConverter.class)
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

    public void setCoordinates(int x, int y) {
        this.coordinates.setX(x);
        this.coordinates.setY(y);
    }

    public static PlayerCell fromString(String dbData) {
        // Assuming dbData is a string representation of coordinates, e.g., "x,y"
        String[] parts = dbData.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid PlayerCell string format");
        }
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        return new PlayerCell(new Coordinates(x, y));
    }
}
