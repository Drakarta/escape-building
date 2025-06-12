package org.example.classes.items.consumables.scrolls;

import org.example.classes.singleton.CurrentRoom;;

public class RoomScroll extends ScrollBase<Void> {

    public RoomScroll() {
        super("Room info scroll", "This magical scroll will help you with information about the room you are currently in", 2);
    }

    @Override
    public void cast(Void unused) {
        System.out.println(CurrentRoom.getInstance().getCurrentRoom().getDescription());
        decreaseAmount();
    }

    public void cast() {
        cast(null);
    }
}
