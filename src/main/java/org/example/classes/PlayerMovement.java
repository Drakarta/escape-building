package org.example.classes;


import org.example.classes.rooms.DoorLink;
import org.example.classes.rooms.cells.DoorCell;
import org.example.classes.rooms.cells.PlayerCell;
import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;
import org.example.classes.singleton.DoorList;
import org.example.classes.singleton.RoomList;
import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;

import java.util.Scanner;

public class PlayerMovement {
    private final PlayerCell player;
    private final RoomLayout room;

    public PlayerMovement(RoomLayout currentRoom) {
        this.player = CurrentUser.getInstance().getCurrentPlayer().getPlayerCell();
        this.room = currentRoom;
    }

    public void handleInput(String input) {
        int dx = 0;
        int dy = 0;
        switch (input.toLowerCase()) {
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
            case "e":
                interact();
                break;
            case "status":
                Player statusPlayer = CurrentUser.getInstance().getCurrentPlayer();
                System.out.println("Username: " + statusPlayer.getUsername() + "\n" + "Current Room: " + statusPlayer.getCurrentRoom() + "\n" + "Hp: " + statusPlayer.getHp());
                break;
            case "inventory":
                inventory();
                break;
            case "doorlist":
                for (DoorLink doorLink : DoorList.getInstance().getAllDoorLinks()) {
                    System.out.printf("Door from '%s' to '%s' [%s] - Locked: %s%n",
                    doorLink.getSourceRoom(),
                    doorLink.getTargetRoom(),
                    doorLink.getDoor().getDoorPosition(),
                    doorLink.getDoor().isLocked());
                }
                break;
            default:
                break;
        }
        
        int newX = player.getCoordinates().getX() + dx;
        int newY = player.getCoordinates().getY() + dy;
        
        if (room.isWalkable(newX, newY)) {
            player.setCoordinates(newX, newY);
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
        }        
    }


    private void inventory() {
        while (true) {
            Player currentPlayer = CurrentUser.getInstance().getCurrentPlayer();
            currentPlayer.getInventory().printInventory(currentPlayer);
            System.out.println("Type 'equip <#>' to equip, or 'back' to exit inventory.");
            Scanner scanner = new Scanner(System.in);
            String invInput = scanner.nextLine().trim().toLowerCase();

            if (invInput.startsWith("equip ")) {
                try {
                    int num = Integer.parseInt(invInput.split(" ")[1]);
                    currentPlayer.equipItemByNumber(num);
                } catch (Exception e) {
                    System.out.println("Invalid command. Try 'equip 1'");
                }
            } else if (invInput.equals("back")) {
                break;
            } else {
                System.out.println("Unknown command. Try 'equip <#>' or 'back'.");
            }
        }
    }
    private void roomChange(String direction) {
        for (DoorCell door : room.getDoors()) {
            if (door.getDoorPosition().equals(direction)) {
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
                    default:
                        break;
                }
                return;
            }
        }
    }


     private void interact() {
         int x = player.getCoordinates().getX();
         int y = player.getCoordinates().getY();

         // Try interaction with adjacent cells
         int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
         for (int[] dir : directions) {
             int nx = x + dir[0];
             int ny = y + dir[1];
             var cell = room.getCell(nx, ny);
             if (cell.isInteractive()) {
                 cell.interact(player, room);
                 break;
             }
         }
     }
}
