package org.example.classes.rooms;

import java.util.ArrayList;
import java.util.List;

import org.example.classes.combat.CombatStarter;
import org.example.classes.questions.QuestionsForm;
import org.example.classes.questions.QuestionsList;
import org.example.classes.rooms.cells.*;

public class RoomLayout {
    private List<List<Cell>> roomLayout;
    private List<DoorCell> doors;
    private List<ChestCell> chests;
    private List<TriggerCell> triggers;
    private Coordinates size;
    private QuestionsForm question;

    public RoomLayout(List<List<Cell>> roomLayout) {
        this.size = new Coordinates(roomLayout.getFirst().size(), roomLayout.size());
        this.roomLayout = roomLayout;
    }

    public RoomLayout(int width, int height, String questionSort, List<DoorCell> doors, List<ChestCell> chests, List<TriggerCell> triggers) {
        this.roomLayout = new ArrayList<>();

        int centerX = width / 2;
        int centerY = height / 2;

        generateRoom(height, width, centerX, centerY);
        this.doors = doors; // Assign before calling setQuestion
        setQuestion(questionSort, centerX, centerY);

        placeDoors(doors, width, height);
        placeChests(chests);

        placeTriggers(triggers);
        this.doors = doors;

        this.size = new Coordinates(width, height);
    }

    private void placeDoors(List<DoorCell> doors, int width, int height) {
        for (DoorCell door : doors) {
            switch (door.getDoorPosition()) {
                case "north":
                    roomLayout.getFirst().set(width / 2, door);
                    break;
                case "south":
                    roomLayout.get(height - 1).set(width / 2, door);
                    break;
                case "east":
                    roomLayout.get(height / 2).set(width - 1, door);
                    break;
                case "west":
                    roomLayout.get(height / 2).set(0, door);
                    break;
                default:
                    break;
            }
        }
    }

    private void placeChests(List<ChestCell> chests) {
        this.chests = new ArrayList<>();
        if (chests == null) return;

        for (ChestCell chest : chests) {
            Coordinates pos = chest.getCoordinates();
            int x = pos.getX();
            int y = pos.getY();

            if (y >= 0 && y < roomLayout.size() && x >= 0 && x < roomLayout.get(0).size()) {
                roomLayout.get(y).set(x, chest);
                this.chests.add(chest);
            } else {
                System.out.println("Warning: Chest position out of bounds: (" + x + ", " + y + ")");
            }
        }
    }


    private void placeTriggers(List<TriggerCell> triggers) {
        if (triggers == null) return;

        for (TriggerCell trigger : triggers) {
            int x = trigger.getCoordinates().getX();
            int y = trigger.getCoordinates().getY();

            if (y >= 0 && y < roomLayout.size() && x >= 0 && x < roomLayout.get(0).size()) {
                roomLayout.get(y).set(x, trigger);
            } else {
                System.out.println("Warning: Trigger position out of bounds: (" + x + ", " + y + ")");
            }
        }
    }

    public List<ChestCell> getChests() {
        return chests;
    }

    public List<List<Cell>> getRoomLayout() {
        return roomLayout;
    }

    public Coordinates getSize() {
        return size;
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
        if (y < 0 || y >= roomLayout.size() || x < 0 || x >= roomLayout.getFirst().size()) {
            return false;
        }
        return roomLayout.get(y).get(x).isWalkable();
    }

    public boolean isDoor(int x, int y) {
        return roomLayout.get(y).get(x).isDoor();
    }

    public Cell getCell(int x, int y) {
        return roomLayout.get(y).get(x);
    }

    public QuestionCell getQuestionCell(int x, int y) {
        Cell cell = roomLayout.get(y).get(x);
        if (cell instanceof QuestionCell questionCell){
            return questionCell;
        }
        return null;
    }

    public QuestionCell getQuestionCell() {
        for (List<Cell> row : roomLayout) {
            for (Cell cell : row) {
                if (cell instanceof QuestionCell questionCell) {
                    return questionCell;
                }
            }
        }
        return null;
    }

    public void clearScreen() {
        System.out.println("\033[2J\033[H");
        System.out.flush();
    }

    public void setQuestion(String questionsSort, int x, int y) {
        QuestionsList list = new QuestionsList();
        this.question = list.getRandomQuestionWithQuestionSort(questionsSort);

        QuestionCell cell = getQuestionCell(x, y);
        if (cell != null) {
            cell.setQuestion(this.question);

            //Add all doors as observers
            if (doors != null) {
                for (DoorCell door : doors) {
                    cell.addObserver(door);
                }
            }
            cell.addObserver(new CombatStarter());
        } else {
            System.err.println("No QuestionCell found at coordinates (" + x + ", " + y + ")");
        }
    }

    public QuestionsForm getQuestion() {
        return question;
    }

    protected void generateRoom(int height, int width, int centerX, int centerY){
        for (int i = 0; i < height; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    row.add(new WallCell());
                } else if (i == centerY && j == centerX) {
                    row.add(new QuestionCell());
                } else {
                    row.add(new EmptyCell());
                }
            }
            this.roomLayout.add(row);
        }
    }
}
