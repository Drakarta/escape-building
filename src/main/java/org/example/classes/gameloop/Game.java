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
        switch (input.toLowerCase()) {
            case "w", "a", "s", "d":
                CurrentRoom.getInstance().getCurrentRoom().getPlayerMovement(input);
                break;
            case "quit", "q":
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command. Please try again.");
                break;
        }
    }

    
}
