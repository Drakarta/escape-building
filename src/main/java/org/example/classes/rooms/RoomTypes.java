package org.example.classes.rooms;

public class RoomTypes extends RoomTemplate {
    private int id;
    private String name;
    private String description;
    private boolean isLocked;
    private String questionCategory;
    private RoomLayout roomLayout;

    public RoomTypes(int id, String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.questionCategory = questionCategory;
        this.roomLayout = roomLayout;
    }

    @Override
    public void details() {
        System.out.println("Details:");
    }

    @Override
    public void question() {
        System.out.println("Question: What is the capital of France?");
    }

    @Override
    public void answer() {
        System.out.println("Answer: Paris");
    }

    @Override
    public void result() {
        System.out.println("Result: Correct!");
    }

    @Override
    public void feedback() {
        System.out.println("Feedback: Well done!");
    }

    @Override
    public RoomLayout getRoomLayout() {
        return roomLayout;
    }
}
