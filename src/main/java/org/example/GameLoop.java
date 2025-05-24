package org.example;

import java.util.Scanner;

import org.example.classes.Status;
import org.example.classes.rooms.RoomList;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.cells.DoorCell;
import org.example.utils.CurrentUser;

import org.example.classes.singleton.CurrentRoom;


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
            case "w", "a", "s", "d":
                CurrentRoom.getInstance().getCurrentRoom().getPlayerMovement(input);
                break;  
        
            default:
                break;
        }
    }
}
