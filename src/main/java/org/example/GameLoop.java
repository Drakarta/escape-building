package org.example;

import java.util.Scanner;

import org.example.classes.CurrentUser;
import org.example.classes.Login;
import org.example.classes.Player;
import org.example.classes.Status;
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
        System.out.println("Do you want to play the Scrum escape-room?    Y/N");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            boolean success = false;

            // Repeat login until successful
            while (!success) {
                System.out.print("Username: ");
                String username = scanner.nextLine();

                System.out.print("Password: ");
                String password = scanner.nextLine();

                success = Login.login(username, password);
                if (!success) {
                    System.out.println("Login failed. Please try again.\n");
                }
            }

            Player player = CurrentUser.getInstance().getCurrentPlayer();
            player.setCurrentRoom("Start Room");
            System.out.println("Welcome, " + player.getUsername() + "!");

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
        } else if (answer.equalsIgnoreCase("N")) {
            System.out.println("Maybe next time!");
        }
    }

    public void handleInput(String input) {
        boolean moved = false;
        for (DoorCell door : currentRoom.getRoomLayout().getDoors()) {
            if (("up".equalsIgnoreCase(input) && "north".equalsIgnoreCase(door.getDoorPosition())) ||
                    ("down".equalsIgnoreCase(input) && "south".equalsIgnoreCase(door.getDoorPosition()))) {

                RoomTemplate nextRoom = RoomList.getInstance().GetRoomByName(door.getToRoom());
                if (nextRoom != null) {
                    currentRoom = nextRoom;
                    CurrentUser.getInstance().getCurrentPlayer().setCurrentRoom(currentRoom.getName());
                    moved = true;
                } else {
                    System.out.println("The door leads to an unknown room.");
                }
                break;
            } else if ("status".equalsIgnoreCase(input)) {
                Status status = new Status();
                System.out.println(status.getStatus(CurrentUser.getInstance().getCurrentPlayer()));
                System.out.println();
            }
        }

        if (!moved) {
            System.out.println("No door in that direction or invalid input.");
        }
    }
}
