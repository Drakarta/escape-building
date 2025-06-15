package org.example.tests.mocks;

import org.example.classes.combat.LootTable;
import org.example.classes.items.Item;

public class LootTableMock extends LootTable {
    public boolean wasRollLootCalled = false;

    @Override
    public Item rollLoot() {
        wasRollLootCalled = true;
        return new Item("Test Sword");
    }
}

