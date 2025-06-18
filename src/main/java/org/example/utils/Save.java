package org.example.utils;

import java.util.List;

import org.example.classes.Player;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.cells.ChestCell;
import org.example.classes.singleton.CurrentUser;
import org.example.classes.singleton.RoomList;

public class Save {
    private Save() {
    }

    public static void saveGame() {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Player current = CurrentUser.getInstance().getCurrentPlayer();
        SaveFile saveFile = new SaveFile(RoomList.getInstance());
        current.setSaveFile(saveFile);
        try {
            hibernateUtil.update(current);
        } catch (Exception e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public static void loadGame() {
        Player current = CurrentUser.getInstance().getCurrentPlayer();
        if (current == null) {
            System.out.println("No current player found.");
            return;
        }
        SaveFile saveFile = current.getSaveFile();
        RoomList roomList = RoomList.getInstance();
        if (saveFile == null || saveFile.getSaveData().isEmpty()) {
            System.out.println("No saved game found.");
            return;
        }
        for (SaveData data : saveFile.getSaveData()) {
            var room = roomList.getRoomByName(data.getRoomName());
            if (room == null) {
                System.out.println("Room not found: " + data.getRoomName());
                continue;
            }
            RoomLayout layout = room.getRoomLayout();
            List<ChestCell> chests = layout.getChests();
            List<Boolean> savedChestStates = data.getChests();

            int loopCount = Math.min(chests.size(), savedChestStates.size());
            for (int i = 0; i < loopCount; i++) {
                ChestCell chest = chests.get(i);
                chest.setOpened(savedChestStates.get(i));
            }
            if (data.getQuestion() == true) {
                layout.getQuestionCell().setAnswered(true);
            } 
        }
    }
}
