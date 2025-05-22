package org.example.classes.questions;

import org.example.classes.hints.DisplayHint;

import java.util.ArrayList;

public class QuestionsForm {
    private int belongsToRoomID;
    private String questionType;
    private String question;
    private ArrayList<String> questionsOrAnswers;
    private ArrayList<DisplayHint> hintList;

    public int getBelongsToRoomID() {
        return belongsToRoomID;
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

    public QuestionsForm(int belongsToRoomID, String questionType, String question, ArrayList<String> questionsOrAnswers, ArrayList<DisplayHint> hintList){
        this.belongsToRoomID = belongsToRoomID;
        this.question = question;
        this.questionType = questionType;
        this.questionsOrAnswers = questionsOrAnswers;
        this.hintList = hintList;
    }
}
