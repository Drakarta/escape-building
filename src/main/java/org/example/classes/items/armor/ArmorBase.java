package org.example.classes.items.armor;

import org.example.classes.items.Item;

public class ArmorBase extends Item {
    protected int durability;
    protected double shield;

    public ArmorBase(String name, int durability, double shield) {
        super(name);
        this.durability = durability;
        this.shield = shield;
    }

    public boolean use() {
        if (durability <= 0) return false;
        durability--;
        return true;
    }

    public double getShield() {
        return shield;
    }

    public int getDurability() {
        return durability;
    }
}
