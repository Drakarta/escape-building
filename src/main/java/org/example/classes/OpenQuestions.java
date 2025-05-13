package org.example.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class OpenQuestions implements QuestionsTemplate {
    @Override
    public boolean ask(String question, String correctAnswer, ArrayList<String> answers) {
        boolean correct = false;
        System.out.println(question);
        System.out.println("Geef uw antwoord");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        for (String q : answers){
            if (answer.equalsIgnoreCase(q)){
                correct = true;
                break;
            }
        }

        return correct;
    }
}
