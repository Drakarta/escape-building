package org.example.classes.questions;

import java.util.ArrayList;

public class Question {
    QuestionsTemplate questionSort;

    public boolean ask(String questionType, String question, ArrayList<String> questionsOrAnswers) {
        if (questionType == null) return false;

        switch (questionType.toLowerCase()) {
            case "openquestion":
                questionSort = new OpenQuestions();
                break;
            case "multipleanswersquestion":
                questionSort = new MultipleAnswersQuestion();
                break;
            case "multiplechoicequestions":
                questionSort = new MultipleChoiceQuestions();
                break;
            default:
                System.err.println("Unknown question type: " + questionType);
                return false;
        }
        return questionSort.ask(question, questionsOrAnswers);
    }
}