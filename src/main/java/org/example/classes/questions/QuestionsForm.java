package org.example.classes.questions;

import org.example.classes.hints.DisplayHint;

import java.util.ArrayList;

public class QuestionsForm {
    private String questionSort;
    private String questionType;
    private String question;
    private ArrayList<String> questionsOrAnswers;
    private ArrayList<DisplayHint> hintList;

    public String getQuestionSort() {
        return questionSort;
    }
    public ArrayList<String> getQuestionsOrAnswers() {
        return questionsOrAnswers;
    }
    public String getQuestion() {
        return question;
    }
    public String getQuestionType() {
        return questionType;
    }
    public ArrayList<DisplayHint> getHints() {
        return hintList;
    }

    public QuestionsForm(String belongsToRoomID, String questionType, String question, ArrayList<String> questionsOrAnswers, ArrayList<DisplayHint> hintList){
        this.questionSort = belongsToRoomID;
        this.question = question;
        this.questionType = questionType;
        this.questionsOrAnswers = questionsOrAnswers;
        this.hintList = hintList;
    }
}
