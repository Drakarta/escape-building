package org.example.classes.monsters;

import org.example.classes.combat.LootTable;
import org.example.classes.items.armor.*;
import org.example.classes.items.weapons.Sword;;

public class Goblin extends Monster {
    public Goblin() {
        super("Goblin", "A small, green, nasty creature", 30, 5, null);
    }

    private LootTable createGoblinLoot() {
        LootTable lootTable = new LootTable();
        lootTable.addLoot(new Sword("Wooden dagger", 10, 3), 0.8); // 50% chance
        lootTable.addLoot(new Armor("Leather armor", 8, 3), 0.2); // 20% chance
        return lootTable;
    }
}
