package org.example.classes.monsters;

import org.example.classes.combat.LootTable;
import org.example.classes.items.weapons.WeaponBase;

public class Worker extends Monster {
    public Worker() {
        super("Worker", "A random worker you just encountered, they are very mad because you mist the daily stand up 3 months ago.", 20, 6);
        setLootTable(createWorkerLoot());
    }

    private LootTable createWorkerLoot() {
        LootTable lootTable = new LootTable();
        lootTable.addLoot(new WeaponBase("Pen", 2, 4), 0.6);
        return lootTable;
    }
}
