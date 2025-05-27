package org.example;

import java.util.Scanner;

import org.example.classes.Status;
import org.example.classes.rooms.DoorLink;
import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;
import org.example.classes.singleton.DoorList;
import org.example.classes.singleton.RoomList;


public class GameLoop {

    public GameLoop() {

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
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
        switch (input.toLowerCase()) {
            case "w", "a", "s", "d", "e":
                CurrentRoom.getInstance().getCurrentRoom().getPlayerMovement(input);
                break;
            case "status":
                Status status = new Status();
                String currentStatus = status.getStatus(CurrentUser.getInstance().getCurrentPlayer());
                System.out.println(currentStatus);
                break;
            case "doorlist":
                for (DoorLink doorLink : DoorList.getInstance().getAllDoorLinks()) {
                    System.out.printf("Door from '%s' to '%s' [%s] - Locked: %s%n",
                            doorLink.getSourceRoom(),
                            doorLink.getTargetRoom(),
                            doorLink.getDoor().getDoorPosition(),
                            doorLink.getDoor().isLocked());
                }
                break;

            default:
                break;
        }
    }
}
