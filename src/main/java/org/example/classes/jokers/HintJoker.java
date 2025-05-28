package org.example.classes.jokers;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.cells.QuestionCell;

public class HintJoker extends Joker {
    @Override
    public void useJoker(RoomTemplate room) {
        QuestionsForm question = room.getRoomLayout().getQuestion();
        QuestionCell questionCell = new QuestionCell();
        questionCell.setQuestion(question);
        questionCell.displayHint();
    }
}