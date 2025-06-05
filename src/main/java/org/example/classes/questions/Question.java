package org.example.classes.questions;

import java.util.ArrayList;

public class Question {
    QuestionsTemplate questionSort;

    public boolean ask(String questionType, String question, ArrayList<String> questionsOrAnswers) {
        switch (questionType) {
            case "OpenQuestion":
                questionSort = new OpenQuestions();
                break;
            case "MultipleAnswersQuestion":
                questionSort = new MultipleAnswersQuestion();
                break;
            case "MultipleChoiceQuestions":
                questionSort = new MultipleChoiceQuestions();
                break;
            case null, default:
                return false;
        }
        return questionSort.ask(question, questionsOrAnswers);
    }
}
