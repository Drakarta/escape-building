package org.example.classes;

import java.util.ArrayList;

public class Question {
    QuestionsTemplate questionSort;

    public boolean ask(String questionType, String question, ArrayList<String> questionsOrAnswers){
        if (questionType.equalsIgnoreCase("OpenQuestion")){ // voor een meerkeuze vraag moet je een vraag meegeven als een string en acceptabele antwoorden meegeven in de 2e ArrayList<String>
            questionSort = new OpenQuestions();
            return questionSort.ask(question, questionsOrAnswers);
        } else if(questionType.equalsIgnoreCase("MultipleAnswersQuestion")){ // met meerdere mogelijke antwoorden geef een String als vraag en een ArrayList<String> als antwoorden
            questionSort = new MultipleAnswersQuestion();
            return questionSort.ask(question, questionsOrAnswers);
        } else if (questionType.equalsIgnoreCase("MultipleChoiceQuestions")){ // met een meerkeuze vraag geef een String als vraag en een ArrayList<String> mee waarvan index 0 het correcte antwoord is(moet ook nog een keer voorkomen in de mogelijke antwoorden) en de rest zijn de mogelijke antwoorden
            questionSort = new MultipleChoiceQuestions();
            return questionSort.ask(question, questionsOrAnswers);
        } else {
                System.out.println("Wrong question type found");
                return false;

        }
    }
}
