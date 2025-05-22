package org.example.classes.rooms;

public abstract class RoomTemplate {
    private int id;
    public String name;
    private String description;
    private boolean isLocked;
    private String questionCategory;
    private RoomLayout roomLayout;

    public RoomTemplate(int id, String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.questionCategory = questionCategory;
        this.roomLayout = roomLayout;
    }

    public abstract void displayRoom();
    public abstract void question();

    public Object getName() {
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
