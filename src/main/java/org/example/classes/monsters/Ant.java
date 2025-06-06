package org.example.classes.monsters;

import org.example.classes.combat.LootTable;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.weapons.WeaponBase;

public class Ant extends Monster {
    public Ant() {
        super("Your colleague Ant", "A usesless worker that only shows up during the daily stand up", 10, 1);
        setLootTable(createAntLoot());
    }

    private LootTable createAntLoot() {
        LootTable lootTable = new LootTable();
        lootTable.addLoot(new WeaponBase("Ant's mouse", 2, 1), 0.2);
        lootTable.addLoot(new WeaponBase("Ant's laptop", 10, 5), 0.2);  
        lootTable.addLoot(new ArmorBase("Ant's gum", 1, 10), 0.2); 
        lootTable.addLoot(new ArmorBase("Ant's anime shirt", 3, 6), 0.2); 
        return lootTable;
    }
}
