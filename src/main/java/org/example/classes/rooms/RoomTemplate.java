package org.example.classes.rooms;

import java.util.Scanner;

import org.example.classes.PlayerMovement;
import org.example.classes.rooms.cells.PlayerCell;

public abstract class RoomTemplate {
    protected RoomLayout layout;
    public abstract void details();
    public abstract void question();
    public abstract void answer();
    public abstract void result();
    public abstract void feedback();
    public abstract RoomLayout getRoomLayout();

    public final void play(int roomIndex) {
        RoomList rooms = RoomList.getInstance();
        PlayerCell player = new PlayerCell(new Coordinates(1, 1));
        RoomLayout layout = getRoomLayout();
        PlayerMovement movement = new PlayerMovement(player, layout);

        Scanner scanner = new Scanner(System.in);
        layout.printRoomLayout(player);

        details();
        //question();
        //answer();
        //result();
        //feedback();

        System.out.print("Enter command (WASD to move, E to interact, Q to quit): ");

        while (true) {
            System.out.println("Player Y: " + player.getCoordinates().getY());
            System.out.println("Room height - 1: " + (layout.getRoomLayout().size() - 1));

            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) continue;

            movement.handleInput(input.charAt(0));
            layout.clearScreen();
            layout.printRoomLayout(player);
            
            if (player.getCoordinates().getY() == 0) {
                roomIndex++;
                layout.clearScreen();
                rooms.getRoomList().get(roomIndex).play(roomIndex);
            }
            
            if (player.getCoordinates().getY() == layout.getRoomLayout().size() - 1) {
                System.out.println("Test");
                if (roomIndex > 0) {
                    System.out.println("test2");
                    roomIndex--;
                    layout.clearScreen();
                    rooms.getRoomList().get(roomIndex).play(roomIndex);
                } else {
                    System.out.println("This is the first room");
                }
            }
        }
    }
}
