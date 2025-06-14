package org.example.classes.items.consumables.potions;

import org.example.classes.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthPotionTest {

    private Player player;

    @BeforeEach
    void setup() {
        // Maak een player met hp < maxHp zodat we kunnen genezen
        player = new Player("testuser", "pass", 50, "Start Room", null);
    }

    @Test
    void consume_increasesHpByPotency() {
        int potency = 30;
        HealthPotion potion = new HealthPotion(potency);

        int originalHp = player.getHp();
        potion.consume(player);

        assertEquals(originalHp + potency, player.getHp());
    }

    @Test
    void consume_doesNotExceedMaxHp() {
        int potency = 1000; // extreem hoog om over maxHP te gaan
        HealthPotion potion = new HealthPotion(potency);

        player.setHp(90); // player zit bijna op maxHP 100
        potion.consume(player);

        assertEquals(100, player.getHp(), "HP mag niet boven maxHp uitkomen");
    }

    @Test
    void consume_whenHpIsMaxHp_remainsMaxHp() {
        player.setHp(100); // al max hp
        HealthPotion potion = new HealthPotion(20);

        potion.consume(player);

        assertEquals(100, player.getHp());
    }
}
