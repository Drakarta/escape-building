package org.example.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleAnswersQuestion implements QuestionsTemplate{
    @Override
    public boolean ask(String question, String correctAnswer, ArrayList<String> answers) {
        System.out.println(question);
        ArrayList<String> inputs = new ArrayList<>();
        int correctAnswers = 0;
        Scanner sc = new Scanner(System.in);
        for (String x : answers) {
            inputs.add(sc.nextLine());
        }
        for (int i = 0; i<= inputs.size(); i++ ) {
            if (inputs.get(i).equalsIgnoreCase(answers.get(i))){
                correctAnswers++;
            }
        }
        return correctAnswers == answers.size();
    }
}
