package org.example.classes.rooms.subclasses;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;

import java.util.ArrayList;

public class TestRoom extends RoomTemplate {
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
        ArrayList<String> questionOrAnswer = new ArrayList<>();
        questionOrAnswer.add("365");
        String question = "Hoeveel dagen in een normaal jaar?";
        String questiontype = "openQuestion";
        QuestionsForm question1 = new QuestionsForm(questiontype, question, questionOrAnswer);
        return new RoomLayout(9, 9, question1);
    }
}
