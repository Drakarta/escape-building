package org.example.classes.questions;

import java.util.ArrayList;

public class Question {
    QuestionsTemplate questionSort;

    public boolean ask(String questionType, String question, ArrayList<String> questionsOrAnswers) {
        switch (questionType.toUpperCase()) {
            case "OPENQUESTION":
                questionSort = new OpenQuestions();
                break;
            case "MULTIPLEANSWERSQUESTION":
                questionSort = new MultipleAnswersQuestion();
                break;
            case "MULTIPLECHOICEQUESTION":
                questionSort = new MultipleChoiceQuestions();
                break;
            case null, default:
                return false;
        }
        return questionSort.ask(question, questionsOrAnswers);
    }
}
