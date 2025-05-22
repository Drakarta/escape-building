package org.example.classes;

import jdk.jshell.Snippet;
import org.example.CurrentUser;
import org.example.classes.rooms.cells.PlayerCell;
import org.example.classes.rooms.RoomLayout;
import org.example.CurrentUser;

public class PlayerMovement {
    private final PlayerCell player;
    private final RoomLayout room;

    public PlayerMovement(PlayerCell player, RoomLayout room) {
        this.player = player;
        this.room = room;
    }

    public void handleInput(String input) {
        int dx = 0, dy = 0;

        switch (input.toLowerCase()) {
            case "w": dy = -1; break;
            case "s": dy = 1; break;
            case "a": dx = -1; break;
            case "d": dx = 1; break;
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
        }

        int newX = player.getCoordinates().getX() + dx;
        int newY = player.getCoordinates().getY() + dy;

        if (room.isWalkable(newX, newY)) {
            player.setCoordinates(newX, newY);
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
