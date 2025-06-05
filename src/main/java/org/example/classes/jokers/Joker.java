package org.example.classes.jokers;

import org.example.classes.rooms.RoomTemplate;

public abstract class Joker {
    public final void useJoker(RoomTemplate room) {
        if (canUseInRoom(room)) {
            applyEffect(room);
        } else {
            System.out.println("Can't use this joker here!");
        }
    }

    protected boolean canUseInRoom(RoomTemplate room) {
        return true;
    }

    protected abstract void applyEffect(RoomTemplate room);
}