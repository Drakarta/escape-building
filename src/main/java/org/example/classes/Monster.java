package org.example.classes;

public abstract class Monster {
    private String name;
    private String description;
    private int hp;
    private Item loot;

    public Monster(String name, String description, int hp, Item loot){
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.loot = loot;
    }
    public void displayInfo(){
        System.out.println("You are facing: " + name);
        System.out.println("It can be described as: " + description);
        System.out.println("It seems to have " + hp + " hp left");
        System.out.println("You have a gut feeling defeating it will give you " + loot.getName());
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

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public void setLoot(Item loot) {
        this.loot = loot;
    }
    public Item getLoot() {
        return loot;
    }
}
