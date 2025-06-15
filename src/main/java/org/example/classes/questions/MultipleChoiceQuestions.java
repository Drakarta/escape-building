package org.example.classes.questions;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoiceQuestions implements QuestionsTemplate {
    public boolean ask(String questions, ArrayList<String> answers) {
        System.out.println(questions);
        System.out.println("Is het correcte antwoord:");
        int i = 1;
        for (int q = 1; q < answers.size(); q++) {
            System.out.println(i + ". " + answers.get(q));
            i++;
        }
        Scanner sc = new Scanner(System.in);
        int choiceInt = sc.nextInt();

        if (choiceInt < 1 || choiceInt >= answers.size()) {
            System.out.println("Ongeldige keuze, keuze buiten bereik.");
            return false;  // niet opnieuw vragen, direct false teruggeven
        }

        String choiceString = answers.get(choiceInt);
        System.out.println(choiceString);
        return choiceString.equals(answers.get(0));  // correct antwoord = index 0
    }

}