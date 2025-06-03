package org.example.classes.rooms.cells;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomLayout;

public interface Cell {
    String printIcon();
    default boolean isWalkable() { return true;} 
    default boolean isInteractive() { return false;}
    default boolean isDoor() { return false; }
    default void interact(PlayerCell player, RoomLayout room) {}
    void setQuestion(QuestionsForm question); // word alleen door questioncell gebruikt maar omdat we alle cellen in een list<Cell> opslaan moet het in de interface als methode staan
}
