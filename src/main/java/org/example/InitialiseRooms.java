package org.example;

import org.example.classes.items.consumables.potions.HealthPotion;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.cells.ChestCell;
import org.example.classes.rooms.cells.DoorCell;
import org.example.classes.rooms.cells.TriggerCell;
import org.example.classes.rooms.roomtypes.Room;

import org.example.classes.singleton.DoorList;
import org.example.classes.singleton.RoomList;

import java.util.List;

public class InitialiseRooms {
    public InitialiseRooms() {
        RoomList roomList = RoomList.getInstance();
        DoorList doorList = DoorList.getInstance();

        // === Room 1: Start Room ===
        List<TriggerCell> triggers = List.of(
                new TriggerCell(TriggerCell.TriggerType.MESSAGE, "Press WASD (and enter) to walk around the room", 1, 5),
                new TriggerCell(TriggerCell.TriggerType.MESSAGE, "10", 1, 2)
        );
        ChestCell potionChest = new ChestCell(new HealthPotion(20), 5, 5);
        DoorCell doorToRoom2 = new DoorCell(true, "north", "Sprint planning kamer");
        RoomLayout startRoomLayout = new RoomLayout(9, 9, "dailyStandup", List.of(doorToRoom2), List.of(potionChest), triggers);

        Room startRoom = new Room("Start Room", "This is room 1", "Category 1", startRoomLayout);
        roomList.addRoom(startRoom);
        doorList.addDoor("Start Room", "Sprint planning kamer", doorToRoom2);

        // === Room 2: Sprint planning kamer ===
        DoorCell doorToStartRoom = new DoorCell(true, "south", "Start Room");
        DoorCell doorToRoom3 = new DoorCell(true, "north", "Scrum board kamer");
        RoomLayout layout2 = new RoomLayout(9, 9, "sprintPlanning", List.of(doorToStartRoom, doorToRoom3), null, null);
        Room room2 = new Room("Sprint planning kamer", "This is the room for the 'Sprint planning'", "Category 2", layout2);
        roomList.addRoom(room2);
        doorList.addDoor("Sprint planning kamer", "Start Room", doorToStartRoom);
        doorList.addDoor("Sprint planning kamer", "Scrum board kamer", doorToRoom3);

        // === Room 3: Scrum board kamer ===
        DoorCell doorToRoom2Back = new DoorCell(true, "south", "Sprint planning kamer");
        DoorCell doorToRoom4 = new DoorCell(true, "north", "Daily scrum kamer");

        ChestCell chest3 = new ChestCell(new HealthPotion(20), 2, 6); // Not center
        RoomLayout layout3 = new RoomLayout(9, 9, "review", List.of(doorToRoom2Back, doorToRoom4), List.of(chest3), null);

        Room room3 = new Room("Scrum board kamer", "Scrum board activity", "Category 2", layout3);
        roomList.addRoom(room3);
        doorList.addDoor("Scrum board kamer", "Sprint planning kamer", doorToRoom2Back);
        doorList.addDoor("Scrum board kamer", "Daily scrum kamer", doorToRoom4);

        // === Room 4: Daily scrum kamer ===
        DoorCell doorToRoom3Back = new DoorCell(true, "south", "Scrum board kamer");
        DoorCell doorToRoom5 = new DoorCell(true, "north", "Sprint review kamer 1");

        ChestCell chest4 = new ChestCell(new HealthPotion(20), 1, 7); // Not center
        RoomLayout layout4 = new RoomLayout(9, 9, "review", List.of(doorToRoom3Back, doorToRoom5), List.of(chest4), null);

        Room room4 = new Room("Daily scrum kamer", "Daily scrum meeting room", "Category 2", layout4);
        roomList.addRoom(room4);
        doorList.addDoor("Daily scrum kamer", "Scrum board kamer", doorToRoom3Back);
        doorList.addDoor("Daily scrum kamer", "Sprint review kamer 1", doorToRoom5);

        // === Room 5: Sprint review kamer ===
        DoorCell doorToRoom4Back = new DoorCell(true, "south", "Daily scrum kamer");
        DoorCell doorToRoom6 = new DoorCell(true, "north", "Sprint retrospective");

        ChestCell chest5 = new ChestCell(new HealthPotion(20), 6, 2); // Not center
        RoomLayout layout5 = new RoomLayout(9, 9, "review", List.of(doorToRoom4Back, doorToRoom6), List.of(chest5), null);

        Room room5 = new Room("Sprint review kamer 1", "First sprint review room", "Category 2", layout5);
        roomList.addRoom(room5);
        doorList.addDoor("Sprint review kamer 1", "Daily scrum kamer", doorToRoom4Back);
        doorList.addDoor("Sprint review kamer 1", "Sprint retrospective", doorToRoom6);

        // === Room 6: Sprint retrospective ===
        DoorCell doorToRoom5Back = new DoorCell(true, "south", "Sprint review kamer 1");
        DoorCell doorToRoom7 = new DoorCell(true, "north", "TIA kamer");

        ChestCell chest6 = new ChestCell(new HealthPotion(20), 1, 1); // Not center
        RoomLayout layout6 = new RoomLayout(9, 9, "review", List.of(doorToRoom5Back, doorToRoom7), List.of(chest6), null);

        Room room6 = new Room("Sprint retrospective", "Reflect and improve", "Category 2", layout6);
        roomList.addRoom(room6);
        doorList.addDoor("Sprint retrospective", "Sprint review kamer 1", doorToRoom5Back);
        doorList.addDoor("Sprint retrospective", "TIA kamer", doorToRoom7);

        // === Room 7: TIA kamer (Final boss room) ===
        DoorCell doorToRoom6Back = new DoorCell(true, "south", "Sprint retrospective");

        ChestCell chest7 = new ChestCell(new HealthPotion(20), 0, 8); // Not center
        RoomLayout layout7 = new RoomLayout(9, 9, "review", List.of(doorToRoom6Back), List.of(chest7), null);

        Room room7 = new Room("TIA kamer", "This is the final boss room", "Category 2", layout7);
        roomList.addRoom(room7);
        doorList.addDoor("TIA kamer", "Sprint retrospective", doorToRoom6Back);
    }
}