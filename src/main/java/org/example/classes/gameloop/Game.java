package org.example.classes.gameloop;

import org.example.classes.singleton.CurrentRoom;

public class Game extends GameTemplate {

    public Game() {
        super();
    }

    @Override
    public void displayRoom() {
        CurrentRoom.getInstance().getCurrentRoom().displayRoom();
    }

    @Override
    public void handleGameInput(String input) {
        CurrentRoom.getInstance().getCurrentRoom().getPlayerMovement(input);
    }
}
