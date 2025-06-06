package org.example.classes.items.consumables.potions;

import org.example.classes.Player;
import org.example.classes.items.Item;

public abstract class PotionBase extends Item {
    protected String effectDescription;
    protected int potency; // e.g. healing amount or effect strength

    protected PotionBase(String name, String effectDescription, int potency) {
        super(name);
        this.effectDescription = effectDescription;
        this.potency = potency;
    }

    public String getEffectDescription() {
        return effectDescription;
    }

    public int getPotency() {
        return potency;
    }

    public abstract void consume(Player player);
}
