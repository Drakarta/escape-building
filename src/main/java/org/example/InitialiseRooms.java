package org.example;

import org.example.classes.items.consumables.potions.HealthPotion;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.cells.ChestCell;
import org.example.classes.rooms.cells.DoorCell;
import org.example.classes.rooms.roomTypes.Room;
import org.example.classes.singleton.DoorList;
import org.example.classes.singleton.RoomList;

import java.util.List;

public class InitialiseRooms {
    InitialiseRooms() {
        RoomList roomList = RoomList.getInstance();
        DoorList doorList = DoorList.getInstance(); // Could be singleton if needed

        // Start room → Room 2
        ChestCell potionChest = new ChestCell(false, new HealthPotion(null, 20), 2, 2);
        DoorCell doorToRoom2 = new DoorCell(true, "north", "Room 2");
        RoomLayout startRoomLayout = new RoomLayout(9, 9, "dailyStandup", List.of(doorToRoom2), List.of(potionChest));
        Room startRoom = new Room("Start Room", "This is room 1", "Category 1", startRoomLayout);

        doorList.addDoor("Start Room", "Room 2", doorToRoom2);

        // Room 2 → Start room
        DoorCell doorToStartRoom = new DoorCell(true, "south", "Start Room");
        RoomLayout layout2 = new RoomLayout(9, 9, "review", List.of(doorToStartRoom), null);
        Room room2 = new Room("Room 2", "This is room 2", "Category 2", layout2);

        doorList.addDoor("Room 2", "Start Room", doorToStartRoom);

        roomList.addRoom(startRoom);
        roomList.addRoom(room2);
    }
}
