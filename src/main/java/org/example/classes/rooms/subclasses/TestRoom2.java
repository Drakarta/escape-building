package org.example.classes.rooms.subclasses;

import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;

public class TestRoom2 extends RoomTemplate {
    @Override
    public void details() {
        System.out.println("2!");
    }

    @Override
    public void question() {
        System.out.println("2?");
    }

    @Override
    public void answer() {
        System.out.println("1");
    }

    @Override
    public void result() {
        System.out.println("2!");
    }

    @Override
    public void feedback() {
        System.out.println("2!");
    }
    
    @Override
    public RoomLayout getRoomLayout() {
        return new RoomLayout(7, 7, "2");
    }
}
