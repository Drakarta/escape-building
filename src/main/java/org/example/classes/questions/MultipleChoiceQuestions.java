package org.example.classes.questions;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoiceQuestions implements QuestionsTemplate {
    public boolean ask(String questions, ArrayList<String> answers) {
        System.out.println(questions);
        System.out.println("Is het correcte antwoord:");
        int i =1;
        for (String q : answers){
            if(!q.equalsIgnoreCase(answers.getFirst())) {
                System.out.println(i + ". " + q);
                i++;
            }
        }
        Scanner sc = new Scanner(System.in);
        int choiceInt = sc.nextInt();

        String choiceString = answers.get(choiceInt - 1);
        return choiceString.equals(answers.getFirst());

    }
}