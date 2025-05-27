package org.example.classes.jokers;

import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.roomTypes.Room;

public abstract class Joker {
    public void useJoker(RoomTemplate room){
        if (room.getDescription().equalsIgnoreCase("This is room 1") || room.getDescription().equalsIgnoreCase("Review")){
        } else {
            System.out.println("Cant use this joker here!");
        }
    }
}
