package org.example;

import java.util.Scanner;

import org.example.classes.rooms.RoomList;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.cells.DoorCell;

public class GameLoop {
    private RoomTemplate currentRoom;

    public GameLoop() {
        this.currentRoom = RoomList.getInstance().GetRoomByName("Start Room");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            currentRoom.displayRoom();
            System.out.println("Where do you want to go? (up/down/quit)");

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }
            handleInput(input);
        }
        scanner.close();
    }

    public void handleInput(String input) {
        boolean moved = false;
        for (DoorCell door : currentRoom.getRoomLayout().getDoors()) {
            if (("up".equalsIgnoreCase(input) && "north".equalsIgnoreCase(door.getDoorPosition())) ||
                ("down".equalsIgnoreCase(input) && "south".equalsIgnoreCase(door.getDoorPosition()))) {

                RoomTemplate nextRoom = RoomList.getInstance().GetRoomByName(door.getToRoom());
                if (nextRoom != null) {
                    currentRoom = nextRoom;
                    moved = true;
                } else {
                    System.out.println("The door leads to an unknown room.");
                }
                break;
            }
        }

        if (!moved) {
            System.out.println("No door in that direction or invalid input.");
        }
    }
}
