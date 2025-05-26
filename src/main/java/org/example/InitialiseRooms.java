package org.example;

import java.util.List;

import org.example.classes.rooms.roomTypes.Room;
import org.example.classes.singleton.RoomList;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.cells.DoorCell;

public class InitialiseRooms {
    InitialiseRooms() {
        RoomList roomList = RoomList.getInstance();

        RoomLayout startRoomLayout = new RoomLayout(9, 9, "Sample Question", List.of(
            new DoorCell(false, "north", "Room 2")
        ));
        Room startRoom = new Room("Start Room", "This is room 1", false, "Category 1", startRoomLayout);

        RoomLayout layout2 = new RoomLayout(9, 9, "Sample Question", List.of(
            new DoorCell(false, "south", "Start Room")
        ));
        Room room2 = new Room("Room 2", "This is room 2", false, "Category 2", layout2);

        roomList.addRoom(startRoom);
        roomList.addRoom(room2);
    }
}
