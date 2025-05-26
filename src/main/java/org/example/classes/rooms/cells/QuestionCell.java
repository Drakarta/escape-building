package org.example.classes.rooms.cells;

import java.util.Scanner;
import org.example.classes.rooms.RoomLayout;

public class QuestionCell implements Cell {
    private String question;

    public QuestionCell(String question) {
        this.question = question;
    }

    @Override
    public String printIcon() {
        return "?";
    }

    @Override
    public boolean isWalkable() {
    return false;
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    @Override
    public void interact(PlayerCell player, RoomLayout room) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question: " + question);
        System.out.print("Answer: ");
        String answer = scanner.nextLine();

        if (answer.trim().equalsIgnoreCase("1")) {
            System.out.println("Correct!");
            for (int y = 0; y < room.getRoomLayout().size(); y++) {
                for (int x = 0; x < room.getRoomLayout().get(y).size(); x++) {
                    Cell cell = room.getCell(x, y);
                    if (cell instanceof DoorCell) {
                        ((DoorCell) cell).unlock();
                    }
                }
            }
        System.out.println("All doors have been unlocked.");
        try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            System.out.println("Wrong answer!");
        }
    }
}