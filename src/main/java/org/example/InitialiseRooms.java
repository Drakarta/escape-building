package org.example;

import java.util.List;

import org.example.classes.rooms.roomTypes.Room;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomList;
import org.example.classes.rooms.cells.DoorCell;

public class InitialiseRooms {
    InitialiseRooms() {
        RoomList roomList = RoomList.getInstance();

        RoomLayout startRoomLayout = new RoomLayout(5, 5, "Sample Question", List.of(
            new DoorCell(false, "north", "Room 2")
        ));
        Room startRoom = new Room(1, "Start Room", "This is room 1", false, "Category 1", startRoomLayout);

        RoomLayout layout2 = new RoomLayout(5, 5, "Sample Question", List.of(
            new DoorCell(false, "south", "Start Room")
        ));
        Room room2 = new Room(2, "Room 2", "This is room 2", false, "Category 2", layout2);

        roomList.addRoom(startRoom);
        roomList.addRoom(room2);
    }
}
