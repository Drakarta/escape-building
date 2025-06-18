package org.example.utils;

import java.util.ArrayList;
import java.util.List;

import org.example.classes.singleton.RoomList;

public class SaveFile {
    private List<SaveData> saveData;

    public SaveFile() {
        this.saveData = new ArrayList<>();
    }

    public SaveFile(RoomList roomList) {
        this.saveData = new ArrayList<>();
        for (var room : roomList.getRoomList()) {
            saveData.add(new SaveData(room));
        }
    }

    public List<SaveData> getSaveData() {
        return saveData;
    }

    public void setSaveData(List<SaveData> saveData) {
        this.saveData = saveData;
    }
}
