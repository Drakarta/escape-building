package org.example.classes.items;

import java.util.ArrayList;
import java.util.List;

import org.example.classes.Player;
import org.example.classes.Extras.Terminal;
import org.example.classes.items.weapons.WeaponBase;
import org.example.utils.databaseconverters.InventoryConverter;

import jakarta.persistence.Convert;

import org.example.classes.items.armor.ArmorBase;

public class Inventory {
    @Convert(converter = InventoryConverter.class)
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public Inventory(List<Item> items) {
        this.items = new ArrayList<>(items); // Create a copy to avoid external modification
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items); // return copy to prevent external modification
    }

    public void printInventory(Player player) {
        List<Item> items = getItems();
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory contains:");
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                String equippedMarker = "";
                String stats = "";
                String colorInventory = Terminal.RESET;

                if (item.equals(player.getEquippedWeapon())) {
                    equippedMarker = " [Equipped Weapon]";
                } else if (item.equals(player.getEquippedArmor())) {
                    equippedMarker = " [Equipped Armor]";
                }

                if (item instanceof WeaponBase weapon) {
                    colorInventory = Terminal.RED;
                    stats = String.format(" (Damage: %.1f, Durability: %d)", weapon.getDamage(), weapon.getDurability());
                } else if (item instanceof ArmorBase armor) {
                    colorInventory = Terminal.BLUE;
                    stats = String.format(" (Shield: %.1f, Durability: %d)", armor.getShield(), armor.getDurability());
                } else if (item instanceof org.example.classes.items.consumables.scrolls.ScrollBase scroll) {
                    colorInventory = Terminal.YELLOW;
                    stats = String.format(" (Scroll: %s, Uses left: %d)", scroll.getSpellDescription(), scroll.getAmount());
                } else {
                    colorInventory = Terminal.CYAN;
                }

                System.out.println(colorInventory + (i + 1) + ". " + item.getName() + stats + equippedMarker + Terminal.RESET);
            }
        }
    }

}