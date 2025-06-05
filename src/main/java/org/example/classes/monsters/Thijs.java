package org.example.classes.monsters;

import org.example.classes.combat.LootTable;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.weapons.WeaponBase;

public class Thijs extends Monster {
    public Thijs() {
        super("Weirdo Thijs", "You just sometimes see him using emojis for variable names", 1, 40, null);
    }

    private LootTable createThijsLoot() {
        LootTable lootTable = new LootTable();
        lootTable.addLoot(new WeaponBase("Thijs' coding duck", 5, 4), 0.6);
        lootTable.addLoot(new WeaponBase("Thijs' laptop", 10, 8), 0.1);  
        lootTable.addLoot(new ArmorBase("Thijs' gamer goggles", 1, 1), 0.1); 
        lootTable.addLoot(new ArmorBase("Thijs' long luscious locks", 1, 0), 0.2); 
        return lootTable;
    }
}
