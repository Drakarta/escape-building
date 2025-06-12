package org.example.classes.items;

import java.util.ArrayList;
import java.util.List;

import org.example.classes.Player;
import org.example.classes.items.weapons.WeaponBase;
import org.example.classes.items.armor.ArmorBase;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
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

            if (item.equals(player.getEquippedWeapon())) {
                equippedMarker = " [Equipped Weapon]";
            } else if (item.equals(player.getEquippedArmor())) {
                equippedMarker = " [Equipped Armor]";
            }

            if (item instanceof WeaponBase weapon) {
                stats = String.format(" (Damage: %.1f, Durability: %d)", weapon.getDamage(), weapon.getDurability());
            } else if (item instanceof ArmorBase armor) {
                stats = String.format(" (Shield: %.1f, Durability: %d)", armor.getShield(), armor.getDurability());
            } else if (item instanceof org.example.classes.items.consumables.scrolls.ScrollBase scroll) {
                stats = String.format(" (Scroll: %s, Uses left: %d)", scroll.getSpellDescription(), scroll.getAmount());
            }

            System.out.println((i + 1) + ". " + item.getName() + stats + equippedMarker);
        }
    }
}

}