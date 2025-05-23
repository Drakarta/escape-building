package org.example.classes.rooms;

import java.util.Scanner;

import org.example.classes.PlayerMovement;
import org.example.classes.rooms.cells.PlayerCell;

public abstract class RoomTemplate {
    private final String name;
    private String description;
    private boolean isLocked;
    private String questionCategory;
    private RoomLayout roomLayout;

    public RoomTemplate(String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.questionCategory = questionCategory;
        this.roomLayout = roomLayout;
    }

    public abstract void displayRoom();
    public abstract void question();

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public String getQuestionCategory() {
        return questionCategory;
    }
    public RoomLayout getRoomLayout() {
        return roomLayout;
    }
}
