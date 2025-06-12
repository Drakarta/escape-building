package org.example.classes.jokers;

import org.example.classes.items.Item;
import org.example.classes.rooms.RoomTemplate;

public abstract class Joker extends Item {
    protected Joker(String name){
        super(name);
    }
    public void useJoker(RoomTemplate room){
        if (canUseIn(room)){
            jokerEffect(room);
        } else {
            System.out.println("Cant use this joker here!");
        }
    }
    protected boolean canUseIn(RoomTemplate room){
        return room.getDescription().equalsIgnoreCase("This is room 1") || room.getDescription().equalsIgnoreCase("Review");
    }
    protected void jokerEffect(RoomTemplate room){}
}