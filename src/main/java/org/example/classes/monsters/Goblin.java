package org.example.classes.monsters;

import org.example.classes.combat.LootTable;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.weapons.WeaponBase;

public class Goblin extends Monster {
    public Goblin() {
        super("Goblin", "A small, green, nasty creature", 30, 5, null);
    }

    private LootTable createGoblinLoot() {
        LootTable lootTable = new LootTable();
        lootTable.addLoot(new WeaponBase("Wooden dagger", 10, 3), 0.8); // 50% chance
        lootTable.addLoot(new ArmorBase("Leather armor", 8, 3), 0.2); // 20% chance
        return lootTable;
    }
}
