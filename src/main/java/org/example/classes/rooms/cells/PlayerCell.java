package org.example.classes.rooms.cells;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.Coordinates;

public class PlayerCell implements Cell {
    private Coordinates coordinates;

    public PlayerCell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String printIcon() {
        return "@";
    }

    @Override
    public void setQuestion(QuestionsForm question) {

    }


    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates.setX(x);
        this.coordinates.setY(y);
    }
}
