package org.example.classes.questions;

import java.util.ArrayList;

public class Question {
    boolean answeredCorrectly = false;
    ArrayList<QuestionObserver> observers =new ArrayList<>();
    QuestionsTemplate questionSort;

    public boolean ask(String questionType, String question, ArrayList<String> questionsOrAnswers){
        if (questionType.equalsIgnoreCase("OpenQuestion")){ // voor een meerkeuze vraag moet je een vraag meegeven als een string en acceptabele antwoorden meegeven in de 2e ArrayList<String>
            questionSort = new OpenQuestions();
            answeredCorrectly = questionSort.ask(question, questionsOrAnswers);
        } else if(questionType.equalsIgnoreCase("MultipleAnswersQuestion")){ // met meerdere mogelijke antwoorden geef een String als vraag en een ArrayList<String> als antwoorden
            questionSort = new MultipleAnswersQuestion();
            answeredCorrectly = questionSort.ask(question, questionsOrAnswers);
        } else if (questionType.equalsIgnoreCase("MultipleChoiceQuestions")){ // met een meerkeuze vraag geef een String als vraag en een ArrayList<String> mee waarvan index 0 het correcte antwoord is(moet ook nog een keer voorkomen in de mogelijke antwoorden) en de rest zijn de mogelijke antwoorden
            questionSort = new MultipleChoiceQuestions();
            answeredCorrectly = questionSort.ask(question, questionsOrAnswers);
        } else {
                System.out.println("Wrong question type found");

        }
        notifyObservers();
        return answeredCorrectly;
    }

    public void addObserver(QuestionObserver observer){
        observers.add(observer);
    }
    private void notifyObservers(){
        for (QuestionObserver q : observers){
            q.questionsUpdate(answeredCorrectly);
        }
    }
}
