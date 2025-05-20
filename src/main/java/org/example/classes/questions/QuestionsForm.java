package org.example.classes.questions;

import java.util.ArrayList;

public class QuestionsForm {
    private String questionType;
    private String question;
    private ArrayList<String> questionsOrAnswers;

    public ArrayList<String> getQuestionsOrAnswers() {
        return questionsOrAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestionType() {
        return questionType;
    }
    public QuestionsForm(String questionType, String question, ArrayList<String> questionsOrAnswers){
        this.question = question;
        this.questionType = questionType;
        this.questionsOrAnswers = questionsOrAnswers;
    }
}
