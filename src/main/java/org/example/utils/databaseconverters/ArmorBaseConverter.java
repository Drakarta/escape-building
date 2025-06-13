package org.example.utils.databaseconverters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.classes.items.armor.ArmorBase;

@Converter(autoApply = true)
public class ArmorBaseConverter implements AttributeConverter<ArmorBase, String> {

    @Override
    public String convertToDatabaseColumn(ArmorBase armor) {
        if (armor == null) return "";
        // CSV formaat: name,durability,shield
        return armor.getName() + "," + armor.getDurability() + "," + armor.getShield();
    }

    @Override
    public ArmorBase convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return null;
        String[] parts = dbData.split(",");
        if (parts.length < 3) return null;

        String name = parts[0];
        int durability = Integer.parseInt(parts[1]);
        double shield = Double.parseDouble(parts[2]);

        return new ArmorBase(name, durability, shield);
    }
}
