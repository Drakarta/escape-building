package org.example;

import java.util.List;

import org.example.classes.rooms.roomTypes.Room;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomList;
import org.example.classes.rooms.cells.DoorCell;

public class InitialiseRooms {
    InitialiseRooms() {
        RoomList roomList = RoomList.getInstance();

        RoomLayout startRoomLayout = new RoomLayout(5, 5, List.of(
            new DoorCell(false, "north", "Room 2")
        ));
        Room startRoom = new Room(1, "Start Room", startRoomLayout);

        RoomLayout layout2 = new RoomLayout(5, 5, List.of(
            new DoorCell(false, "south", "Start Room")
        ));
        Room room2 = new Room(2, "room2", layout2);

        roomList.addRoom(startRoom);
        roomList.addRoom(room2);
    }
}
