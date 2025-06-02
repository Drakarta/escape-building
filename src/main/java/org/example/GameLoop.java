package org.example;

import java.util.Scanner;

import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;
import org.example.classes.singleton.RoomList;


public class GameLoop {
    Scanner scanner = new Scanner(System.in);
    public GameLoop() {

    }

    public void start() {
        
        while (true) {
            CurrentRoom.getInstance().setCurrentRoom(RoomList.getInstance().getRoomByName(CurrentUser.getInstance().getCurrentPlayer().getCurrentRoom()));
            CurrentRoom.getInstance().getCurrentRoom().displayRoom();

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
        CurrentRoom.getInstance().getCurrentRoom().getPlayerMovement(input);
    }
}

