package org.example.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoiceQuestions implements QuestionsTemplate {
    public boolean ask(ArrayList<String> questionAndAnswer, ArrayList<String> answers) {
        System.out.println(questionAndAnswer.getFirst());
        System.out.println("Is het correcte antwoord:");
        int i =1;
        for (String q : answers){
            System.out.println(i + ". " + q);
            i++;
        }
        Scanner sc = new Scanner(System.in);
        int choiceInt = sc.nextInt();

        String choiceString = answers.get(choiceInt - 1);
        return choiceString.equals(questionAndAnswer.getLast());

    }
}
