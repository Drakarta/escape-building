package org.example.classes.rooms.roomTypes;

import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.singleton.CurrentUser;

public class Room extends RoomTemplate {
    public Room(String name, String description, boolean isLocked, String questionCategory, RoomLayout roomLayout) {
        super(name, description, isLocked, questionCategory, roomLayout);
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
