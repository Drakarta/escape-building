package org.example.classes.items.consumables.scrolls;

import org.example.classes.items.Item;

public abstract class ScrollBase<T> extends Item {
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

    protected void decreaseAmount() {
        if (amount > 0) {
            amount--;
        }
    }

    public abstract void cast(T target);
}
