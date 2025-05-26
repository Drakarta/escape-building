package org.example.classes.rooms;

import java.util.Scanner;

import org.example.classes.PlayerMovement;
import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.cells.PlayerCell;

public abstract class RoomTemplate {
    private int id;
    public String name;
    private String description;
    private boolean isLocked;
    private QuestionsForm questionCategory;
    private RoomLayout roomLayout;

    protected RoomTemplate(){}

    public RoomTemplate(int id, String name, String description, boolean isLocked, QuestionsForm questionCategory, RoomLayout roomLayout) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.questionCategory = questionCategory;
        this.roomLayout = roomLayout;
    }
    public RoomTemplate(int id, String name, RoomLayout roomLayout){
        this.id = id;
        this.name = name;
        this.roomLayout = roomLayout;
    }

    public abstract void details();

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
    public QuestionsForm getQuestionCategory() {
        return questionCategory;
    }
    public RoomLayout getRoomLayout() {
        return roomLayout;
    }


    public final void play(int roomIndex) {
        RoomList rooms = RoomList.getInstance();
        PlayerCell player = new PlayerCell(new Coordinates(1, 1));
        RoomLayout layout = getRoomLayout();
        PlayerMovement movement = new PlayerMovement(player, layout);

        Scanner scanner = new Scanner(System.in);
        layout.printRoomLayout(player);

        //details();
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

            movement.handleInput(input);
//            layout.clearScreen();
            layout.printRoomLayout(player);
            
            if (player.getCoordinates().getY() == 0) {
                roomIndex++;
//                layout.clearScreen();
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
