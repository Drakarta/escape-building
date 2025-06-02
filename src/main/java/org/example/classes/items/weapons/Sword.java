package org.example.classes.items.weapons;

public class Sword extends WeaponBase{
    public Sword(String name, int durability, int damage) {
        super(name, durability, damage);
        this.durability = durability;
        this.damage = damage;
    }
}
