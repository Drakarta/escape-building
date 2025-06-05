package org.example;

import java.util.Scanner;

import org.example.classes.rooms.RoomLayout;
import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;


public class GameLoop {

    public GameLoop() {

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            CurrentRoom.getInstance().getCurrentRoom().displayRoom();
            CurrentUser.getInstance().getCurrentPlayer().setCurrentRoom(CurrentRoom.getInstance().getCurrentRoom().getName());

            String input = scanner.nextLine().trim();
            handleInput(input);
            
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }
        }
        scanner.close();
    }

    public void handleInput(String input) {
        switch (input) {
            case "w", "a", "s", "d", "e":
                CurrentRoom.getInstance().getCurrentRoom().getPlayerMovement(input);
                break;  
        
            default:
                break;
        }
    }
}
