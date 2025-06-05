package org.example.classes.rooms.subclasses;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;

public class TestRoom2 extends RoomTemplate {

    public TestRoom2(String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        super(name, description, isLocked, questionCategory, roomLayout);
    }

    public void details() {
        System.out.println("2!");
    }

    @Override
    public void displayRoom() {

    }

    @Override
    public void question() {
        System.out.println("2?");
    }

    public void answer() {
        System.out.println("1");
    }

    public void result() {
        System.out.println("2!");
    }

    public void feedback() {
        System.out.println("2!");
    }
    
    @Override
    public RoomLayout getRoomLayout() {
        return null;
        //return new RoomLayout(7, 7, "2");
    }
}
