package org.example.classes.gameloop;

import java.util.Scanner;

import org.example.InitialiseRooms;
import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;
import org.example.classes.singleton.RoomList;
import org.example.utils.Login;
import org.example.utils.Register;
import org.example.utils.Save;
import org.example.classes.items.StarterItems;

public abstract class GameTemplate {
    private final Scanner scanner = new Scanner(System.in);

    protected GameTemplate() {
    }
    
    public void start() {
        startUp();
        gameLoop();
    }

    public String handleInput() {
        return scanner.nextLine().trim();
    }

    public void startUp() {
        System.out.println("Welcome to the Scrum Escape Room!");
        System.out.println("");
        System.out.println("    - (L) Login");
        System.out.println("    - (R) Register");
        System.out.println("    - (Q) Quit");
        System.out.println("");
        System.out.println("Please choose an option:");
        String input = handleInput();
        switch (input.toLowerCase()) {
            case "login", "l":
                login();
                break;
            case "register", "r":
                register();
                break;
            case "quit", "q":
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    public void login() {
        int fails = 0;
        while (fails < 3) {
            System.out.print("Username: ");
            String username = handleInput();

            System.out.print("Password: ");
            String password = handleInput();

            boolean success = Login.login(username, password);
            if (!success) {
                System.out.println("Login failed. Please try again.\n");
            }
            else {
                System.out.println("Login successful!");
                break; 
            }
        }
    }

    public void register() {
        while (true) {
            System.out.print("username: ");
            String username = handleInput();
            System.out.print("password: ");
            String password = handleInput();
            System.out.print("repeat password: ");
            String repeatPassword = handleInput(); 
            if (!password.equals(repeatPassword)) {
                System.out.println("Passwords do not match. Please try again.");
                return;
            }
            if (Register.register(username, password)) {
                System.out.println("Registration successful!");
                break;
            } else {
                System.out.println("Registration failed. Please try again.");
            }
        }
        StarterItems.startingItems();
    }

    public void gameLoop() {
        new InitialiseRooms();
        CurrentRoom.getInstance().setCurrentRoom(RoomList.getInstance().getRoomByName(CurrentUser.getInstance().getCurrentPlayer().getCurrentRoom()));
        while(true) {
            displayRoom();
            String input = handleInput();
            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
                Save.saveGame();
                System.out.println("Goodbye!");
                return;
            }
            handleGameInput(input);
        }
    }
    abstract void displayRoom();
    abstract void handleGameInput(String input);
}
