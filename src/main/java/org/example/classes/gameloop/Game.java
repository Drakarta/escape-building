package org.example.classes.gameloop;

import org.example.classes.Extras.Terminal;
import org.example.classes.singleton.CurrentRoom;

public class Game extends GameTemplate {

    public Game() {
    }

    @Override
    public void displayRoom() {
        Terminal.clearScreen();
        CurrentRoom.getInstance().getCurrentRoom().displayRoom();
    }

    @Override
    public void handleGameInput(String input) {
        CurrentRoom.getInstance().getCurrentRoom().getPlayerMovement(input);
    }
}
