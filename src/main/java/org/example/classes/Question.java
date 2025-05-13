package org.example.classes;

import java.util.ArrayList;

public class Question {
    QuestionsTemplate questionSort;

    public boolean ask(String questionType, String correctAnwer, String question, ArrayList<String> questionsOrAnswers){
        if (questionType.equalsIgnoreCase("OpenQuestion")){
            questionSort = new OpenQuestions();
            return questionSort.ask(question, correctAnwer, questionsOrAnswers);
        } else if(questionType.equalsIgnoreCase("MultipleAnswersQuestion")){
            questionSort = new MultipleAnswersQuestion();
            return questionSort.ask(question, correctAnwer, questionsOrAnswers);
        } else if (questionType.equalsIgnoreCase("MultipleChoiceQuestions")){
            questionSort = new MultipleChoiceQuestions();
            return questionSort.ask(question, correctAnwer, questionsOrAnswers);
        } else {
                System.out.println("Wrong question type found");
                return false;

        }
    }
}
