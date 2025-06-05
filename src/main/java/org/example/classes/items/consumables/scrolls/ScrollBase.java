package org.example.classes.items.consumables.scrolls;

import org.example.classes.items.Item;
import org.example.classes.monsters.Monster;

public abstract class ScrollBase extends Item {
    protected String spellDescription;
    protected int amount;

    public ScrollBase(String name, String spellDescription, int amount) {
        super(name);
        this.spellDescription = spellDescription;
        this.amount = amount;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public int getAmount() {
        return amount;
    }

    public abstract void cast(Monster monster);
}
