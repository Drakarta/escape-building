package org.example.utils;

import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.cells.PlayerCell;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class PlayerCellConverter implements AttributeConverter<PlayerCell, String> {

    @Override
    public String convertToDatabaseColumn(PlayerCell attribute) {
        if (attribute == null) return null;
        Coordinates c = attribute.getCoordinates();
        return c.getX() + "," + c.getY();
    }

    @Override
    public PlayerCell convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return null;
        String[] parts = dbData.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        return new PlayerCell(new Coordinates(x, y));
    }
}
