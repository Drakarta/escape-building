package org.example.classes;

import java.util.ArrayList;

public interface QuestionsTemplate {
    boolean ask(String question, String correctAnswer, ArrayList<String> anwersOrQuestions);
}
