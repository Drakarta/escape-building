package org.example;

import java.util.Scanner;

import org.example.classes.Player;
import org.example.classes.rooms.RoomLoader;
import org.example.classes.singleton.*;
import org.example.utils.DatabaseConnection;
import org.example.utils.Login;
import org.example.classes.items.weapons.*;
import org.example.classes.items.armor.*;

public class Game {
    public void gameloop(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play the Scrum escape-room?    Y/N");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Y")) {

            login(scanner);
            CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new Sword("Wooden sword", 999, 999));
            CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new Armor("Leather armor", 3, 5));
            CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new Armor("Chainmail armor", 3, 4));
            //this is the game logic loop
            new InitialiseRooms();
            CurrentUser.getInstance().getCurrentPlayer().setCurrentRoom(RoomLoader.getInstance().getCurrentDatabaseRoom());
            CurrentRoom.getInstance().setCurrentRoom(RoomList.getInstance().getRoomByName(CurrentUser.getInstance().getCurrentPlayer().getCurrentRoom()));
            GameLoop gameLoop = new GameLoop();
            gameLoop.start();
        }
        else if (answer.equalsIgnoreCase("N")) {
            System.out.println("Maybe next time!");
        }
    }

    public void login(Scanner scanner) {
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
        player.setCurrentRoom(RoomLoader.getInstance().getCurrentDatabaseRoom());
        System.out.println("Welcome, " + player.getUsername() + "!");
    }

}
