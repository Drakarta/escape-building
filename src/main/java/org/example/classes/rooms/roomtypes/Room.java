package org.example.classes.rooms.roomtypes;

import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.singleton.CurrentUser;

public class Room extends RoomTemplate {
    public Room(String name, String description, String questionCategory, RoomLayout roomLayout) {
        super(name, description, questionCategory, roomLayout);
    }

    @Override
    public void displayRoom() {
        System.out.println(getName());
        getRoomLayout().printRoomLayout(CurrentUser.getInstance().getCurrentPlayer().getPlayerCell());
    }

    @Override
    public void question() {
        
    }
}
