package org.example.classes.rooms.subclasses;

import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTypes;

public class TestRoom extends RoomTypes {
    public TestRoom() {
        super(
            1, // id
            "Test Room", // name
            "This is a test room.", // description
            false, // isLocked
            "Open question", // questionCategory
            null // RoomLayout or pass appropriate RoomLayout if needed
        );
    }

    @Override
    public void details() {
        System.out.println("1!");
    }

    @Override
    public void question() {
        System.out.println("1?");
    }

    @Override
    public void answer() {
        System.out.println("1");
    }

    @Override
    public void result() {
        System.out.println("Correct!");
    }

    @Override
    public void feedback() {
        System.out.println("!");
    }
    
    @Override
    public RoomLayout getRoomLayout() {
        return new RoomLayout(9, 9, "?");
    }
}
