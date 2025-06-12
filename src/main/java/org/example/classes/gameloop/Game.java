package org.example.classes.gameloop;

import org.example.classes.singleton.CurrentRoom;

public class Game extends GameTemplate {

    private Game() {
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
