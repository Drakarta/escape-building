package org.example.classes.rooms;

import java.util.ArrayList;
import java.util.List;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.cells.*;

public class RoomLayout {
    private List<List<Cell>> roomLayout;
    private List<DoorCell> doors;
    private Coordinates size;
    private ArrayList<Integer> questionCoordinates = new ArrayList<>();


    public RoomLayout(List<List<Cell>> roomLayout) {
        this.size = new Coordinates(roomLayout.get(0).size(), roomLayout.size());
        this.roomLayout = roomLayout;
    }

    public RoomLayout(int width, int height, List<DoorCell> doors) {
        this.roomLayout = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    row.add(new WallCell());
                } else if (i == height / 2 && j == width / 2) {
                    row.add(new QuestionCell());
                    questionCoordinates.add(i);
                    questionCoordinates.add(j);
                } else {
                    row.add(new EmptyCell());
                }
            }
            this.roomLayout.add(row);
        }
        for (DoorCell door : doors) {
            if (door.getDoorPosition().equals("north")) {
                roomLayout.get(0).set(width / 2, door);
            } else if (door.getDoorPosition().equals("south")) {
                roomLayout.get(height - 1).set(width / 2, door);
            } else if (door.getDoorPosition().equals("east")) {
                roomLayout.get(height / 2).set(width - 1, door);
            } else if (door.getDoorPosition().equals("west")) {
                roomLayout.get(height / 2).set(0, door);
            }
        }
        this.doors = doors;
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
    }
    
    public List<DoorCell> getDoors() {
        return doors;
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


    public void setQuestion(QuestionsForm question){
        getCell(questionCoordinates.getFirst(), questionCoordinates.getLast()).setQuestion(question);
    }
}
