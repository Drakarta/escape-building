package org.example.classes.rooms.subclasses;

import java.util.ArrayList;

import org.example.classes.hints.FunnyHint;
import org.example.classes.hints.HelpHint;
import org.example.classes.hints.HintList;
import org.example.classes.questions.QuestionsForm;
import org.example.classes.questions.QuestionsList;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTypes;

public class TestRoom2 extends RoomTypes {
    public TestRoom2() {
        super(
            2, 
            "Test Room 2", 
            "This is test room 2.", 
            false, 
            "Open question", 
            null 
        );
    }

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
        QuestionsForm question = new QuestionsList().getRandomQuestionWithRoomID(this.getId());
        return new RoomLayout(9, 9, question);
    }
}
