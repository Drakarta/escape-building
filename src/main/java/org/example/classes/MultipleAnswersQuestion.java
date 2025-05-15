package org.example.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleAnswersQuestion implements QuestionsTemplate{
    @Override
    public boolean ask(String questions, ArrayList<String> correctAnswers) {
        System.out.println(questions);
        ArrayList<String> inputs = new ArrayList<>();
        int correctAnswered = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i<= correctAnswers.size(); i++) {
            String currentAnswer = sc.nextLine();
            inputs.add(currentAnswer);
            System.out.println(i + ". " + currentAnswer);
        }
        System.out.println(inputs.getLast());
        for (int i = 0; i< inputs.size(); i++ ) {
            System.out.println(inputs.get(i));
            if (inputs.get(i).equalsIgnoreCase(correctAnswers.get(i))){
                correctAnswered++;
            }
        }
        return correctAnswered == correctAnswers.size();
    }
}
