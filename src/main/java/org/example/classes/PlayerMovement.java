package org.example.classes;


import org.example.classes.rooms.cells.DoorCell;
import org.example.classes.rooms.cells.PlayerCell;
import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;
import org.example.classes.singleton.RoomList;
import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;

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
                 return;
             case "q":
                 System.exit(0);
                 return;
             case "status":
                 Status status = new Status();
                 String currentState = status.getStatus(CurrentUser.getInstance().getCurrentPlayer());
                 System.out.println(currentState);
                 break;
            default:
                break;
        }
        
        int newX = player.getCoordinates().getX() + dx;
        int newY = player.getCoordinates().getY() + dy;
        
        if (room.isWalkable(newX, newY)) {
            player.setCoordinates(newX, newY);
            if (room.isDoor(newX, newY)) {
                Coordinates coordinates = new Coordinates(newX, newY);
                if (coordinates.getY() == 0) {
                    RoomChange("north");
                } else if (coordinates.getY() == room.getSize().getY() - 1) {
                    RoomChange("south");
                } else if (coordinates.getX() == 0) {
                    RoomChange("west");
                } else if (coordinates.getX() == room.getSize().getX() - 1) {
                    RoomChange("east");
                }
            }
        }        
    }

    private void RoomChange(String direction) {
        for (DoorCell door : room.getDoors()) {
            if (door.getDoorPosition().equals(direction)) {
                RoomTemplate nextRoom = RoomList.getInstance().getRoomByName(door.getToRoom());

                // 🔄 Update current room in the CurrentUser
                CurrentUser.getInstance().getCurrentPlayer().setCurrentRoom(door.getToRoom());

                // 🔄 Update singleton CurrentRoom
                CurrentRoom.getInstance().setCurrentRoom(nextRoom);

                // Reposition the player based on entry direction
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

             if (room.isInsideBounds(nx, ny)) {
                 var cell = room.getCell(nx, ny);
                 if (cell.isInteractive()) {
                     cell.interact(player, room);
                     break;
                 }
             }
         }
     }
}
