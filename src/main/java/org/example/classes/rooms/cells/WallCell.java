package org.example.classes.rooms.cells;

import org.example.classes.questions.QuestionsForm;

public class WallCell implements Cell {
    @Override
    public String printIcon() {
        return "#";
    }

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public void setQuestion(QuestionsForm question) {

    }

}
