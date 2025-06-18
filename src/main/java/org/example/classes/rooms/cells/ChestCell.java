package org.example.classes.rooms.cells;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.example.classes.items.Item;
import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.singleton.CurrentUser;

public class ChestCell implements Cell {
    private boolean isOpened;
    private Item containedItem;
    private final Coordinates coordinates;

    public ChestCell(Item containedItem, int x, int y) {
        this.isOpened = false;
        this.containedItem = containedItem;
        this.coordinates = new Coordinates(x, y);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    @Override
    public String printIcon() {
        return "C";
    }

    @Override
    public void interact(PlayerCell player, RoomLayout room) {
        if (isOpened) {
            System.out.println("The chest is empty.");
            return;
        }

        System.out.println("You open the chest...");
        if (containedItem != null) {
            System.out.println("You found: " + containedItem.getName());
            CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(containedItem);
            containedItem = null;
        } else {
            System.out.println("The chest is empty.");
        }
        isOpened = true;
    }
}
