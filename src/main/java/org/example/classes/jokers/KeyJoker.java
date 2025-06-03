package org.example.classes.jokers;

import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.UnlockDoors;


public class KeyJoker extends Joker {
    public KeyJoker(String name) {
        super(name);
    }

    @Override
    public void useJoker(RoomTemplate room) {
        if(canUseIn(room)){
            jokerEffect(room);
        } else {
            System.out.println("Cant use this joker here!");
        }
    }

    @Override
    protected boolean canUseIn(RoomTemplate room){
        return room.getDescription().equalsIgnoreCase("This is room 1") || room.getDescription().equalsIgnoreCase("Review");
    }
    @Override
    protected void jokerEffect(RoomTemplate room){
        new UnlockDoors(room.getRoomLayout());
        System.out.println("Doors have been unlocked");
    }
}