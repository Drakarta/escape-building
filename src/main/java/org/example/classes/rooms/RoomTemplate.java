package org.example.classes.rooms;

import java.util.Scanner;

import org.example.classes.PlayerMovement;
import org.example.classes.rooms.cells.PlayerCell;

public abstract class RoomTemplate {
    public final void play() {
        PlayerCell player = new PlayerCell(new Coordinates(1, 1));
        RoomLayout layout = new RoomLayout(9,9, "Question"); // existing layout setup
        PlayerMovement movement = new PlayerMovement(player, layout);

        Scanner scanner = new Scanner(System.in);
        layout.printRoomLayout(player);

        System.out.print("Enter command (WASD to move, E to interact, Q to quit): ");

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) continue;

            movement.handleInput(input.charAt(0));
            layout.clearScreen();
            layout.printRoomLayout(player);
        }

        //details();
        //question();
        //answer();
        //result();
        //feedback();
    }

    //public abstract void details();
    //public abstract void question();
    //public abstract void answer();
    //public abstract void result();
    //public abstract void feedback();
}
