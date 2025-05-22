package org.example;
import org.example.classes.Player;
import org.example.classes.rooms.RoomList;
import org.example.utils.*;
import org.example.CurrentUser;

import org.example.classes.rooms.subclasses.TestRoom;
import org.example.classes.rooms.subclasses.TestRoom2;

import java.util.Scanner;

public class Game {
    public void gameloop(){
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

            //this is the game logic loop
            while (true) {
                RoomList rooms = RoomList.getInstance();
                rooms.addRoom(new TestRoom());
                rooms.addRoom(new TestRoom2());
                rooms.getRoomList().get(0).play(0);
            }
        }
        else if (answer.equalsIgnoreCase("N")) {
            System.out.println("Maybe next time!");
        }
    }
}
