package org.example.utils;

import java.util.ArrayList;
import java.util.List;

import org.example.classes.rooms.RoomTemplate;

public class SaveData {
    private String roomName;
    private Boolean question;
    private List<Boolean> chests;

    public SaveData() {
        this.chests = new ArrayList<>();
    }

    public SaveData(RoomTemplate room) {
        this.roomName = room.getName();
        this.question = room.getRoomLayout().getQuestionCell().getAnswered();

        var chestList = room.getRoomLayout().getChests();
        this.chests = new ArrayList<>();
        if (chestList != null) {
            for (var chest : chestList) {
                System.out.println(chest.isOpened());
                this.chests.add(chest.isOpened());
            }
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Boolean getQuestion() {
        return question;
    }

    public void setQuestion(Boolean question) {
        this.question = question;
    }

    public List<Boolean> getChests() {
        return chests;
    }

    public void setChests(List<Boolean> chests) {
        this.chests = chests;
    }
}
