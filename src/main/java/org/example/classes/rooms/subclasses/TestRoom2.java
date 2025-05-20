package org.example.classes.rooms.subclasses;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;

import java.util.ArrayList;

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
        ArrayList<String> questionOrAnswer = new ArrayList<>();
        questionOrAnswer.add("7");
        String question = "Hoeveel dagen in een week?";
        String questiontype = "openQuestion";
        QuestionsForm question2 = new QuestionsForm(questiontype, question, questionOrAnswer);
        return new RoomLayout(7, 7, question2);
    }
}
