package org.example.classes.rooms.cells;

public class QuestionCell implements Cell {
    private String question;

    public QuestionCell(String question) {
        this.question = question;
    }

    @Override
    public String printIcon() {
        return "?";
    }
}