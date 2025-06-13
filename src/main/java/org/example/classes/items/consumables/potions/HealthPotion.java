package org.example.classes.items.consumables.potions;

import org.example.classes.Player;

public class HealthPotion extends PotionBase {

    public HealthPotion(int potency) {
        super("Health Potion", "Restores " + potency + " HP.", potency);
    }

    @Override
    public void consume(Player player) {
        int originalHp = player.getHp();
        player.setHp(originalHp + potency);
        System.out.println("You drink the health potion and restore " + potency + " HP.");
        System.out.println("Your HP is now: " + player.getHp());
    }

}
