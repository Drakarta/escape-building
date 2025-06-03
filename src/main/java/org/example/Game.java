package org.example;

import java.util.Scanner;

import org.example.classes.Player;
import org.example.classes.jokers.HintJoker;
import org.example.classes.jokers.KeyJoker;
import org.example.classes.rooms.RoomLoader;
import org.example.classes.singleton.*;
import org.example.utils.Login;
import org.example.classes.items.weapons.*;
import org.example.classes.items.armor.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    public void gameloop(){
        System.out.println("Do you want to play the Scrum escape-room?    Y/N");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            login();
            startingItems();
            //this is the game logic loop
            new InitialiseRooms();
            GameLoop gameLoop = new GameLoop();
            gameLoop.start();
        }
        else if (answer.equalsIgnoreCase("N")) {
            System.out.println("Maybe next time!");
        }
    }

    public void login() {
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
        CurrentRoom.getInstance().setCurrentRoom(RoomList.getInstance().getRoomByName(player.getCurrentRoom()));

        System.out.println("Welcome, " + player.getUsername() + "!");
    }
    private void startingItems(){
        System.out.println("Do you want a 'KeyJoker', a 'HintJoker' or nothing?");
        String chosenJoker = scanner.nextLine();
        if (chosenJoker.equalsIgnoreCase("KeyJoker")) {
            CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new KeyJoker("KeyJoker"));
            System.out.println("You got a KeyJoker!");
        } else if(chosenJoker.equalsIgnoreCase("HintJoker")) {
            CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new HintJoker("HintJoker"));
            System.out.println("You got a HintJoker!");
        } else{
            System.out.println("You have chosen nothing like a true warrior!");
        }
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new WeaponBase("Wooden sword", 999, 999));
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new ArmorBase("Leather armor", 3, 5));
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new ArmorBase("Chainmail armor", 3, 4));

    }

}
