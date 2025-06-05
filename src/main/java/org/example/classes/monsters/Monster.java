package org.example.classes.monsters;

import org.example.classes.combat.LootTable;
import org.example.classes.items.Item;

public abstract class Monster {
    private String name;
    private String description;
    private int hp;
    private int attackDamage;
    private Item loot;
    private LootTable lootTable;

    protected Monster(String name, String description, int hp, int attackDamage, Item loot){
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.loot = loot;
    }
    public void displayInfo(){
        printName();
        System.out.println("It can be described as: " + description);
        System.out.println("It seems to have " + hp + " hp left");
        System.out.println("You have a gut feeling defeating it will give you " + loot.getName());
    }
    public void printName(){
        System.out.println("You are facing: " + name);
    }

    public void generateLoot() {
        if (loot == null) {
            loot = lootTable.rollLoot();
        }
    }

    public Item getRolledLoot() {
        return loot;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " takes " + damage + " damage.");
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    public Item rollLoot() {
        return lootTable != null ? lootTable.rollLoot() : null;
    }
}
