package org.example;
import org.example.classes.*;
import java.util.Scanner;


//Heb nog geen subklasses
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = Login.login(username, password);
        if (success) {
            Player player = CurrentUser.getInstance().getCurrentPlayer();
            System.out.println("Welcome, " + player.getUsername() + "!");
        } else {
            System.out.println("Login failed.");
        }

        Game game = new Game();
        game.gameplayLoop();
    }
}