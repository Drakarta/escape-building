package org.example.classes.rooms.subclasses;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.questions.QuestionsList;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTypes;

import java.util.ArrayList;

public class TestRoom extends RoomTypes {
    public TestRoom() {
        super(
            1, 
            "Test Room", 
            "This is a test room.", 
            false, 
            "Open question",
            null 
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
        QuestionsForm question = new QuestionsList().getRandomQuestionWithRoomID(this.getId());
        return new RoomLayout(9, 9, question);
    }
}
