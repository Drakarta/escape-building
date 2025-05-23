package org.example.classes.rooms;

import java.util.Scanner;

import org.example.classes.PlayerMovement;
import org.example.classes.rooms.cells.PlayerCell;

public abstract class RoomTemplate {
    private final String name;
    private String description;
    private boolean isLocked;
    private String questionCategory;
    private RoomLayout roomLayout;

    public RoomTemplate(String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.questionCategory = questionCategory;
        this.roomLayout = roomLayout;
    }

    public abstract void displayRoom();
    public abstract void question();

    public Object getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public String getQuestionCategory() {
        return questionCategory;
    }
    public RoomLayout getRoomLayout() {
        return roomLayout;
    }

//     public final void play(int roomIndex) {
//         RoomList rooms = RoomList.getInstance();
//         PlayerCell player = new PlayerCell(new Coordinates(1, 1));
//         RoomLayout layout = getRoomLayout();
//         PlayerMovement movement = new PlayerMovement(player, layout);

//         Scanner scanner = new Scanner(System.in);
//         layout.printRoomLayout(player);

//         System.out.print("Enter command (WASD to move, E to interact, Q to quit): ");

//         while (true) {
//             System.out.println("Player Y: " + player.getCoordinates().getY());
//             System.out.println("Room height - 1: " + (layout.getRoomLayout().size() - 1));

//             String input = scanner.nextLine().toLowerCase();
//             if (input.isEmpty()) continue;

//             movement.handleInput(input);
// //            layout.clearScreen();
//             layout.printRoomLayout(player);
            
//             if (player.getCoordinates().getY() == 0) {
//                 roomIndex++;
// //                layout.clearScreen();
//                 rooms.getRoomList().get(roomIndex).play(roomIndex);
//             }
            
//             if (player.getCoordinates().getY() == layout.getRoomLayout().size() - 1) {
//                 System.out.println("Test");
//                 if (roomIndex > 0) {
//                     System.out.println("test2");
//                     roomIndex--;
//                     layout.clearScreen();
//                     rooms.getRoomList().get(roomIndex).play(roomIndex);
//                 } else {
//                     System.out.println("This is the first room");
//                 }
//             }
//         }
    // }
}
