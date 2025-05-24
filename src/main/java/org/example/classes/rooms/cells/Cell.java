package org.example.classes.rooms.cells;

import org.example.classes.rooms.RoomLayout;

public interface Cell {
    String printIcon();
    default boolean isWalkable() { return true;} 
    default boolean isInteractive() { return false;}
    default boolean isDoor() { return false; }
    default void interact(PlayerCell player, RoomLayout room) {}
}
