package org.example.classes.items.consumables.scrolls;

import org.example.classes.items.Item;

public abstract class ScrollBase extends Item {
    protected String spellDescription;

    public ScrollBase(String name, String spellDescription) {
        super(name);
        this.spellDescription = spellDescription;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public abstract void cast();
}
