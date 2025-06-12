package org.example;

import org.example.classes.items.consumables.potions.HealthPotion;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.cells.ChestCell;
import org.example.classes.rooms.cells.DoorCell;
import org.example.classes.rooms.cells.TriggerCell;
import org.example.classes.rooms.roomTypes.*;

import org.example.classes.singleton.DoorList;
import org.example.classes.singleton.RoomList;

import java.util.List;

public class InitialiseRooms {
    public InitialiseRooms() {
        RoomList roomList = RoomList.getInstance();
        DoorList doorList = DoorList.getInstance(); // Could be singleton if needed

        // Start room → Room 2
        List<TriggerCell> triggers = List.of(
            new TriggerCell(TriggerCell.TriggerType.MESSAGE, "Press WASD (and enter) to walk around the room", 1, 5),
            new TriggerCell(TriggerCell.TriggerType.MESSAGE, "10", 1, 2)
        );
        ChestCell potionChest = new ChestCell(false, new HealthPotion(null, 20), 5, 5);
        DoorCell doorToRoom2 = new DoorCell(true, "north", "Room 2");
        RoomLayout startRoomLayout = new RoomLayout(9, 9, "dailyStandup", List.of(doorToRoom2), List.of(potionChest), triggers);
        Room startRoom = new Room("Start Room", "This is room 1", "Category 1", startRoomLayout);





        doorList.addDoor("Start Room", "Room 2", doorToRoom2);

        // Room 2 → Start room
        DoorCell doorToStartRoom = new DoorCell(true, "south", "Start Room");
        RoomLayout layout2 = new RoomLayout(9, 9, "review", List.of(doorToStartRoom), null, null);
        Room room2 = new Room("Room 2", "This is room 2", "Category 2", layout2);

        doorList.addDoor("Room 2", "Start Room", doorToStartRoom);

        roomList.addRoom(startRoom);
        roomList.addRoom(room2);
    }
}
