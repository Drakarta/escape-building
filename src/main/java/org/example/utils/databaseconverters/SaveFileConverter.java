package org.example.utils.databaseconverters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.utils.SaveData;
import org.example.utils.SaveFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class SaveFileConverter implements AttributeConverter<SaveFile, String> {

    // Converts a SaveFile object into a single string for database storage
    @Override
    public String convertToDatabaseColumn(SaveFile saveFile) {
        if (saveFile == null || saveFile.getSaveData() == null) {
            return "";
        }

        // Format: roomName|question|chest1,chest2,...;roomName|question|chest1,...
        return saveFile.getSaveData().stream().map(data -> {
            String chests = data.getChests() != null
                    ? data.getChests().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))
                    : "";
            return data.getRoomName() + "|" + data.getQuestion() + "|" + chests;
        }).collect(Collectors.joining(";"));
    }

    // Converts the database string back into a SaveFile object
    @Override
    public SaveFile convertToEntityAttribute(String dbData) {
        SaveFile saveFile = new SaveFile();

        if (dbData == null || dbData.trim().isEmpty()) {
            return saveFile; // Return empty SaveFile
        }

        List<SaveData> saveDataList = new ArrayList<>();
        String[] roomEntries = dbData.split(";");

        for (String roomEntry : roomEntries) {
            String[] parts = roomEntry.split("\\|", -1); // allow empty strings

            if (parts.length < 3) {
                System.err.println("Skipping malformed save entry: " + roomEntry);
                continue;
            }

            try {
                String roomName = parts[0];
                Boolean question = Boolean.parseBoolean(parts[1]);
                String chestData = parts[2];

                List<Boolean> chests = new ArrayList<>();
                if (!chestData.isEmpty()) {
                    chests = Arrays.stream(chestData.split(","))
                            .map(Boolean::parseBoolean)
                            .collect(Collectors.toList());
                }

                SaveData data = new SaveData();
                data.setRoomName(roomName);
                data.setQuestion(question);
                data.setChests(chests);

                saveDataList.add(data);
            } catch (Exception e) {
                System.err.println("Error parsing save entry: " + roomEntry);
                e.printStackTrace(); // Optional: comment this out in production
            }
        }

        saveFile.setSaveData(saveDataList);
        return saveFile;
    }
}
