package org.example.classes.questions;

import org.example.classes.hints.DisplayHint;
import org.example.classes.hints.HintList;

import java.util.ArrayList;

public class QuestionsForm {
    private String questionType;
    private String question;
    private ArrayList<String> questionsOrAnswers;
    private HintList hintlist;

    public ArrayList<String> getQuestionsOrAnswers() {
        return questionsOrAnswers;
    }
    public String getQuestion() {
        return question;
    }
    public String getQuestionType() {
        return questionType;
    }
    public HintList getHints() {
        return hintlist;
    }

    public QuestionsForm(String questionType, String question, ArrayList<String> questionsOrAnswers, HintList hintlist){
        this.question = question;
        this.questionType = questionType;
        this.questionsOrAnswers = questionsOrAnswers;
        this.hintlist = hintlist;
    }
}