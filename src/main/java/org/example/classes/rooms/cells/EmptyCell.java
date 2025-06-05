package org.example.classes.rooms.cells;

import org.example.classes.questions.QuestionsForm;

public class EmptyCell implements Cell {
    @Override
    public String printIcon() {
        return " ";
    }

}