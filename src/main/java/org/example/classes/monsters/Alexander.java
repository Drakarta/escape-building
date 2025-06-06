package org.example.classes.monsters;

import org.example.classes.combat.LootTable;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.weapons.WeaponBase;

public class Alexander extends Monster {
    public Alexander() {
        super("Your boss Alexander", "Your very evil surperior, he wants to punnish you for no reason", 100, 20);
        setLootTable(createAlexanderLoot());
    }

    private LootTable createAlexanderLoot() {
        LootTable lootTable = new LootTable();
        lootTable.addLoot(new WeaponBase("Alexanders strikers game", 20, 10), 0.2);
        lootTable.addLoot(new WeaponBase("Alexanders charger", 1, 99), 0.01);  
        lootTable.addLoot(new ArmorBase("Alexanders glasses", 5, 10), 0.3); 
        lootTable.addLoot(new ArmorBase("Alexanders mustage", 40, 2), 0.2); 
        return lootTable;
    }
}
