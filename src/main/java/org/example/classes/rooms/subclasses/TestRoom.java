package org.example.classes.rooms.subclasses;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;

public class TestRoom extends RoomTemplate {


    public TestRoom(String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        super(name, description, isLocked, questionCategory, roomLayout);
    }

    public void details() {
        System.out.println("1!");
    }

    @Override
    public void displayRoom() {

    }

    @Override
    public void question() {
        System.out.println("1?");
    }

    public void answer() {
        System.out.println("1");
    }

    public void result() {
        System.out.println("Correct!");
    }

    public void feedback() {
        System.out.println("!");
    }

    @Override
    public RoomLayout getRoomLayout() {
        return null;
        //return new RoomLayout(9, 9, "?");
    }
}
