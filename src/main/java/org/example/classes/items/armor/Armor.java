package org.example.classes.items.armor;

public class Armor extends ArmorBase{
    public Armor(String name, int durability, int shield) {
        super(name, durability, shield);
        this.durability = durability;
        this.shield = shield;
    }
}
