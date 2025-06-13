package org.example.classes;

import org.example.classes.combat.CombatStarter;
import org.example.classes.rooms.DoorLink;
import org.example.classes.rooms.cells.Cell;
import org.example.classes.rooms.cells.DoorCell;
import org.example.classes.rooms.cells.PlayerCell;
import org.example.classes.rooms.cells.TriggerCell;
import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;
import org.example.classes.singleton.DoorList;
import org.example.classes.singleton.RoomList;
import org.example.utils.Save;
import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;

import java.util.Scanner;

public class PlayerMovement {
    private final PlayerCell player;
    private final RoomLayout room;
    Scanner scanner = new Scanner(System.in);

    public PlayerMovement(RoomLayout currentRoom) {
        this.player = CurrentUser.getInstance().getCurrentPlayer().getPlayerCell();
        this.room = currentRoom;
    }

    public void handleInput(String input) {
        int dx = 0;
        int dy = 0;
        input = input.toLowerCase().trim();

        switch (input) {
            case "w":
                dy = -1;
                break;
            case "s":
                dy = 1;
                break;
            case "a":
                dx = -1;
                break;
            case "d":
                dx = 1;
                break;
            case "help":
                printHelp();
                return;
            case "taunt":
                triggerCombat();
                return;
            case "e":
                interact();
                return;
            case "status":
                showStatus();
                return;
            case "inventory":
                inventory();
                return;
            case "doorlist":
                showDoorList();
                return;
            default:
                System.out.println("Unknown command.");
                return;
        }

        int newX = player.getCoordinates().getX() + dx;
        int newY = player.getCoordinates().getY() + dy;

        if (room.isWalkable(newX, newY)) {
            player.setCoordinates(newX, newY);

            Cell newCell = room.getCell(newX, newY);
            if (newCell instanceof TriggerCell trigger) {
                trigger.stepOnTrigger();
            }

            if (room.isDoor(newX, newY)) {
                if (newY == 0) {
                    roomChange("north");
                } else if (newY == room.getSize().getY() - 1) {
                    roomChange("south");
                } else if (newX == 0) {
                    roomChange("west");
                } else if (newX == room.getSize().getX() - 1) {
                    roomChange("east");
                }
            }

            // Optional: 5% chance of random encounter on movement
            if (Math.random() < 0.05) {
                triggerCombat();
            }
        } else {
            System.out.println("You can't move there!");
        }
    }

    private void printHelp() {
        System.out.printf("%-15s %s%n", "W, A, S, D", "Are the movement keys");
        System.out.printf("%-15s %s%n", "E", "This is the interact key");
        System.out.printf("%-15s %s%n", "Inventory", "Opens your inventory");
        System.out.printf("%-15s %s%n", "Status", "Displays character info");
        System.out.printf("%-15s %s%n", "Taunt", "Start combat");
        System.out.println();
    }

    private void triggerCombat() {
        CombatStarter combatStarter = new CombatStarter();
        combatStarter.startCombatGoblin();
    }

    private void interact() {
        System.out.println("[DEBUG] Interact triggered at " + player.getCoordinates().getX() + ", " + player.getCoordinates().getY());
        int x = player.getCoordinates().getX();
        int y = player.getCoordinates().getY();

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            Cell cell = room.getCell(nx, ny);
            if (cell != null && cell.isInteractive()) {
                cell.interact(player, room);
                return;
            }
        }
        System.out.println("There is nothing to interact with nearby.");
    }

    private void showStatus() {
        Player player = CurrentUser.getInstance().getCurrentPlayer();
        System.out.println("Username: " + player.getUsername());
        System.out.println("Current Room: " + player.getCurrentRoom());
        System.out.println("HP: " + player.getHp());
    }

    private void inventory() {
        while (true) {
            Player currentPlayer = CurrentUser.getInstance().getCurrentPlayer();
            currentPlayer.getInventory().printInventory(currentPlayer);
            System.out.println("Type 'equip <#>', 'use <#>', or 'back'.");

            String invInput = scanner.nextLine().trim().toLowerCase();

            if (invInput.startsWith("equip ")) {
                try {
                    int num = Integer.parseInt(invInput.split(" ")[1]);
                    currentPlayer.equipItemByNumber(num);
                } catch (Exception e) {
                    System.out.println("Invalid command. Try 'equip 1'");
                }
            } else if (invInput.startsWith("use ")) {
                try {
                    int num = Integer.parseInt(invInput.split(" ")[1]);
                    currentPlayer.useItemByNumber(num);
                } catch (Exception e) {
                    System.out.println("Invalid command. Try 'use 1'");
                }
            } else if (invInput.equals("back")) {
                break;
            } else {
                System.out.println("Unknown command. Try 'equip <#>', 'use <#>' or 'back'.");
            }
        }
    }

    private void showDoorList() {
        for (DoorLink doorLink : DoorList.getInstance().getAllDoorLinks()) {
            System.out.printf("Door from '%s' to '%s' [%s] - Locked: %s%n",
                    doorLink.getSourceRoom(),
                    doorLink.getTargetRoom(),
                    doorLink.getDoor().getDoorPosition(),
                    doorLink.getDoor().isLocked());
        }
    }

    private void roomChange(String direction) {
        for (DoorCell door : room.getDoors()) {
            if (door.getDoorPosition().equals(direction)) {
                Save.saveGame();
                RoomTemplate nextRoom = RoomList.getInstance().getRoomByName(door.getToRoom());

                CurrentUser.getInstance().getCurrentPlayer().setCurrentRoom(door.getToRoom());
                CurrentRoom.getInstance().setCurrentRoom(nextRoom);

                Coordinates nextRoomSize = nextRoom.getRoomLayout().getSize();
                switch (direction) {
                    case "north":
                        player.setCoordinates(nextRoomSize.getX() / 2, nextRoomSize.getY() - 2);
                        break;
                    case "south":
                        player.setCoordinates(nextRoomSize.getX() / 2, 1);
                        break;
                    case "west":
                        player.setCoordinates(nextRoomSize.getX() - 2, nextRoomSize.getY() / 2);
                        break;
                    case "east":
                        player.setCoordinates(1, nextRoomSize.getY() / 2);
                        break;
                }
                return;
            }
        }
    }
}
