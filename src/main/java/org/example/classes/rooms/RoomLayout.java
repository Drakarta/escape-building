package org.example.classes.rooms;

import java.util.ArrayList;
import java.util.List;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.cells.*;

public class RoomLayout {
    private List<List<Cell>> roomLayout;
    private Coordinates size;

    public RoomLayout(List<List<Cell>> roomLayout) {
        this.size = new Coordinates(roomLayout.get(0).size(), roomLayout.size());
        this.roomLayout = roomLayout;
    }

    public RoomLayout(int width, int height, QuestionsForm Question) {
        this.roomLayout = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
            if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                if (j == width / 2) {
                    row.add(new DoorCell(true, null));
                } else{
                    row.add(new WallCell());
                }
            } else if (i == height / 2 && j == width / 2) {
                row.add(new QuestionCell(Question));
            } else {
                row.add(new EmptyCell());
            }
            }
            this.roomLayout.add(row);
        }
        this.size = new Coordinates(roomLayout.get(0).size(), roomLayout.size());
    }

    public List<List<Cell>> getRoomLayout() {
        return roomLayout;
    }

    public void printRoomLayout(PlayerCell player) {
    for (int y = 0; y < roomLayout.size(); y++) {
        List<Cell> row = roomLayout.get(y);
        for (int x = 0; x < row.size(); x++) {
            if (player != null && player.getCoordinates().getX() == x && player.getCoordinates().getY() == y) {
                System.out.print(player.printIcon() + " ");
            } else {
                System.out.print(row.get(x).printIcon() + " ");
            }
        }
        System.out.println();
    }
    System.out.println("Room size: " + size.getX() + "x" + size.getY());
    }

    public boolean isWalkable(int x, int y) {
    if (y < 0 || y >= roomLayout.size() || x < 0 || x >= roomLayout.get(0).size()) {
        return false;
    }
    return roomLayout.get(y).get(x).isWalkable();
    }

    public boolean isInsideBounds(int x, int y) {
        return y >= 0 && y < roomLayout.size() &&
           x >= 0 && x < roomLayout.get(y).size();
    }

    public Cell getCell(int x, int y) {
        return roomLayout.get(y).get(x);
    }

    public void clearScreen() {
        System.out.println("\033[2J\033[H");
        System.out.flush();
    }
}
