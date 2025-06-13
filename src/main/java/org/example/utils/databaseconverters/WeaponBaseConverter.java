package org.example.utils.databaseconverters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.classes.items.weapons.WeaponBase;

@Converter(autoApply = true)
public class WeaponBaseConverter implements AttributeConverter<WeaponBase, String> {

    @Override
    public String convertToDatabaseColumn(WeaponBase weapon) {
        if (weapon == null) return "";
        return weapon.getName() + "," + weapon.getDurability() + "," + weapon.getDamage();
    }

    @Override
    public WeaponBase convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return null;
        String[] parts = dbData.split(",");
        if (parts.length < 3) return null;

        String name = parts[0];
        int durability = Integer.parseInt(parts[1]);
        double damage = Double.parseDouble(parts[2]);

        return new WeaponBase(name, durability, damage);
    }
}
