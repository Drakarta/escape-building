package org.example.classes.jokers;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.cells.QuestionCell;

public class HintJoker extends Joker {
    public HintJoker(String name) {
        super(name);
    }

    @Override
    public void useJoker(RoomTemplate room) {
        if (canUseIn(room)) {
            jokerEffect(room);
        } else{
            System.out.println("Cant use this joker here!");
        }
    }

    @Override
    protected boolean canUseIn(RoomTemplate room){
        return true;
    }
    @Override
    protected void jokerEffect(RoomTemplate room){
        QuestionsForm question = room.getRoomLayout().getQuestion();
        QuestionCell questionCell = new QuestionCell();
        questionCell.setQuestion(question);
        questionCell.displayHint();
    }
}