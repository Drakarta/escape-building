package org.example.classes.combat;

import org.example.classes.items.Item;

import java.util.*;

public class LootTable {
    private static class LootEntry {
        Item item;
        double dropChance; // value between 0 and 1

        LootEntry(Item item, double dropChance) {
            this.item = item;
            this.dropChance = dropChance;
        }
    }

    private final List<LootEntry> entries = new ArrayList<>();
    private final Random random = new Random();

    public void addLoot(Item item, double chance) {
        entries.add(new LootEntry(item, chance));
    }

    public Item rollLoot() {
    List<Item> possibleLoot = new ArrayList<>();
    for (LootEntry entry : entries) {
        if (random.nextDouble() < entry.dropChance) {
            possibleLoot.add(entry.item);
        }
    }
    if (possibleLoot.isEmpty()) {
        // Fallback: guarantee one drop randomly
        return entries.get(random.nextInt(entries.size())).item;
    } else {
        // Return one of the successful drops
        return possibleLoot.get(random.nextInt(possibleLoot.size()));
    }
}

}
