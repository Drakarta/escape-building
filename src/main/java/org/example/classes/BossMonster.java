package org.example.classes;

public class BossMonster extends Monster{
    private String dialogue;
    public BossMonster(String name, String description, int hp, Item loot) {
        super(name, description, hp, loot);
    }
    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }
    public void talk(){
        System.out.println(dialogue);
    }
}
