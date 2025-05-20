package org.example.classes.questions;

import java.util.ArrayList;

public class QuestionsList {
    private ArrayList<QuestionsForm> questionslist = new ArrayList<>();

    public void addQuestion(QuestionsForm question){
        questionslist.add(question);
    }
    public ArrayList<QuestionsForm> getQuestionslist() {
        return questionslist;
    }
}
