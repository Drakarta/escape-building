package org.example.classes.items.weapons;

import org.example.classes.items.Item;
import org.example.utils.databaseconverters.WeaponBaseConverter;

import jakarta.persistence.Convert;

public class WeaponBase extends Item {
    @Convert(converter = WeaponBaseConverter.class)
    protected int durability;
    protected double damage;

    public WeaponBase(String name, int durability, double damage) {
        super(name);
        this.durability = durability;
        this.damage = damage;
    }

    public boolean use() {
        if (durability <= 0) return false;
        durability--;
        return true;
    }

    public double getDamage() {
        return damage;
    }

    public int getDurability() {
        return durability;
    }
}
