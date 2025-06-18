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

        String room1Naam = "Start Room";
        String room2Naam = "Sprint planning kamer";
        String room3Naam = "Scrum board kamer";
        String room4Naam = "Daily scrum kamer";
        String room5Naam = "Sprint review kamer 1";
        String room6naam = "Sprint retrospective";
        String room7Naam = "TIA kamer";
        // === Room 1: Start Room ===
        List<TriggerCell> triggers = List.of(
                new TriggerCell(TriggerCell.TriggerType.MESSAGE, "Press WASD (and enter) to walk around the room", 1, 5),
                new TriggerCell(TriggerCell.TriggerType.MESSAGE, "10", 1, 2)
        );
        ChestCell potionChest = new ChestCell(new HealthPotion(20), 5, 5);
        DoorCell doorToRoom2 = new DoorCell(true, "north", room2Naam);
        RoomLayout startRoomLayout = new RoomLayout(9, 9, "introduction", List.of(doorToRoom2), List.of(potionChest), triggers);

        Room startRoom = new Room(room1Naam, "This is room 1", "Category 1", startRoomLayout);
        roomList.addRoom(startRoom);
        doorList.addDoor(room1Naam, room2Naam, doorToRoom2);

        // === Room 2: Sprint planning kamer ===
        DoorCell doorToStartRoom = new DoorCell(true, "south", room1Naam);
        DoorCell doorToRoom3 = new DoorCell(true, "north", room3Naam);
        RoomLayout layout2 = new RoomLayout(9, 9, "sprintPlanning", List.of(doorToStartRoom, doorToRoom3), null, null);
        Room room2 = new Room(room2Naam, "This is the room for the 'Sprint planning'", "Category 2", layout2);
        roomList.addRoom(room2);
        doorList.addDoor(room2Naam, room1Naam, doorToStartRoom);
        doorList.addDoor(room2Naam, room3Naam, doorToRoom3);

        // === Room 3: Scrum board kamer ===
        DoorCell doorToRoom2Back = new DoorCell(true, "south", room2Naam);
        DoorCell doorToRoom4 = new DoorCell(true, "north", room4Naam);

        ChestCell chest3 = new ChestCell(new HealthPotion(20), 2, 6); // Not center
        RoomLayout layout3 = new RoomLayout(9, 9, "review", List.of(doorToRoom2Back, doorToRoom4), List.of(chest3), null);

        Room room3 = new Room(room3Naam, "Scrum board activity", "Category 2", layout3);
        roomList.addRoom(room3);
        doorList.addDoor(room3Naam, room2Naam, doorToRoom2Back);
        doorList.addDoor(room3Naam, room4Naam, doorToRoom4);

        // === Room 4: Daily scrum kamer ===
        DoorCell doorToRoom3Back = new DoorCell(true, "south", room3Naam);
        DoorCell doorToRoom5 = new DoorCell(true, "north", room5Naam);

        ChestCell chest4 = new ChestCell(new HealthPotion(20), 1, 7); // Not center
        RoomLayout layout4 = new RoomLayout(9, 9, "review", List.of(doorToRoom3Back, doorToRoom5), List.of(chest4), null);

        Room room4 = new Room(room4Naam, "Daily scrum meeting room", "Category 2", layout4);
        roomList.addRoom(room4);
        doorList.addDoor(room4Naam, room3Naam, doorToRoom3Back);
        doorList.addDoor(room4Naam, room5Naam, doorToRoom5);

        // === Room 5: Sprint review kamer ===
        DoorCell doorToRoom4Back = new DoorCell(true, "south", room4Naam);
        DoorCell doorToRoom6 = new DoorCell(true, "north", room6naam);

        ChestCell chest5 = new ChestCell(new HealthPotion(20), 6, 2); // Not center
        RoomLayout layout5 = new RoomLayout(9, 9, "review", List.of(doorToRoom4Back, doorToRoom6), List.of(chest5), null);

        Room room5 = new Room(room5Naam, "First sprint review room", "Category 2", layout5);
        roomList.addRoom(room5);
        doorList.addDoor(room5Naam, room4Naam, doorToRoom4Back);
        doorList.addDoor(room5Naam, room6naam, doorToRoom6);

        // === Room 6: Sprint retrospective ===
        DoorCell doorToRoom5Back = new DoorCell(true, "south", room5Naam);
        DoorCell doorToRoom7 = new DoorCell(true, "north", room7Naam);

        ChestCell chest6 = new ChestCell(new HealthPotion(20), 1, 1); // Not center
        RoomLayout layout6 = new RoomLayout(9, 9, "review", List.of(doorToRoom5Back, doorToRoom7), List.of(chest6), null);

        Room room6 = new Room(room6naam, "Reflect and improve", "Category 2", layout6);
        roomList.addRoom(room6);
        doorList.addDoor(room6naam, room5Naam, doorToRoom5Back);
        doorList.addDoor(room6naam, room7Naam, doorToRoom7);

        // === Room 7: TIA kamer (Final boss room) ===
        DoorCell doorToRoom6Back = new DoorCell(true, "south", room6naam);

        ChestCell chest7 = new ChestCell(new HealthPotion(20), 0, 8); // Not center
        RoomLayout layout7 = new RoomLayout(9, 9, "review", List.of(doorToRoom6Back), List.of(chest7), null);

        Room room7 = new Room(room7Naam, "This is the final boss room", "Category 2", layout7);
        roomList.addRoom(room7);
        doorList.addDoor(room7Naam, room6naam, doorToRoom6Back);
    }
}