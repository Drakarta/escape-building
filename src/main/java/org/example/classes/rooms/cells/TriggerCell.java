package org.example.classes.rooms.cells;

import org.example.classes.Extras.Terminal;
import org.example.classes.items.Item;
import org.example.classes.rooms.Coordinates;
import org.example.classes.singleton.CurrentUser;

public class TriggerCell implements Cell {
    public enum TriggerType {
        MESSAGE, ITEM
    }

    private final TriggerType type;
    private final String messageData;
    private final Item itemData;
    private boolean triggered;
    private final Coordinates coordinates;

    public TriggerCell(String message, int x, int y) {
        this.type = TriggerType.MESSAGE;
        this.messageData = message;
        this.itemData = null;
        this.triggered = false;
        this.coordinates = new Coordinates(x, y);
    }

    public TriggerCell(Item item, int x, int y) {
        this.type = TriggerType.ITEM;
        this.messageData = null;
        this.itemData = item;
        this.triggered = false;
        this.coordinates = new Coordinates(x, y);
    }

    @Override
    public String printIcon() {
        return " ";
    }

    public void stepOnTrigger() {
        if (triggered) return;

        switch (type) {
            case MESSAGE -> {
                System.out.println(messageData);
            }
            case ITEM -> {
                CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(itemData);
                System.out.println("You found: " + itemData.getName()); 
            }
        }

        Terminal.pauseBriefly();
        triggered = true;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
