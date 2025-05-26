package org.example.classes.rooms;

import org.example.classes.PlayerMovement;

public abstract class RoomTemplate {
    private final String name;
    private String description;
    private boolean isLocked;
    private String questionCategory;
    private RoomLayout roomLayout;
    private PlayerMovement playerMovement;

    public RoomTemplate(String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.questionCategory = questionCategory;
        this.roomLayout = roomLayout;
        this.playerMovement = new PlayerMovement(roomLayout);
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

    public void getPlayerMovement(String input) {
        playerMovement.handleInput(input);
    }   
}
