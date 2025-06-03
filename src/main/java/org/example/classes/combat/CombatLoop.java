package org.example.classes.combat;

import org.example.classes.Player;
import org.example.classes.items.Item;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.monsters.Monster;

import java.util.Scanner;

public class CombatLoop {
    private final Player player;
    private final Monster monster;
    private final Scanner scanner;

    public CombatLoop(Player player, Monster monster, Scanner scanner) {
        this.player = player;
        this.monster = monster;
        this.scanner = scanner;
    }

    public void startCombat() {
        monster.printName();
        while (player.getHp() > 0 && monster.isAlive()) {
            System.out.println("\n--- Your Turn ---");
            System.out.println("1. Attack");
            System.out.println("2. Use Item");
            System.out.println("3. Flee");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    if (player.getEquippedWeapon() == null) {
                        System.out.println("You have no weapon equipped!");
                    } else {
                        boolean used = player.getEquippedWeapon().use();
                        if (used) {
                            int damage = (int) player.getEquippedWeapon().getDamage();
                            System.out.println("You strike the " + monster.getName() + "!");
                            monster.takeDamage(damage);
                        } else {
                            System.out.println("Your weapon is broken!");
                        }
                    }
                    break;

                case "2":
                    player.getInventory().printInventory(player);
                    break;

                case "3":
                    System.out.println("You fled the battle!");
                    return;

                default:
                    System.out.println("Invalid input.");
                    continue;
            }

            if (!monster.isAlive()) {
                killedMonster();
                return;
            }

            monsterTurn();
        }
    }

    protected void monsterTurn(){
        System.out.println("\n--- " + monster.getName() + "'s Turn ---");
        int damage = monster.getAttackDamage();
        ArmorBase armor = player.getEquippedArmor();
        int reducedDamage = damage;

        if (armor != null && armor.getDurability() > 0) {
            boolean stillEffective = armor.use();
            if (stillEffective) {
                reducedDamage -= armor.getShield();
                if (reducedDamage < 0) {
                    reducedDamage = 0;
                    System.out.println("Your armor blocks " + armor.getShield() + " damage!");
                }
                System.out.println("Armor durability left: " + armor.getDurability());
            } else {
                System.out.println("Your armor is broken!");
            }
        }

        player.setHp(player.getHp() - reducedDamage);
        System.out.println(monster.getName() + " hits you for " + reducedDamage + " damage. Your HP: " + Math.max(player.getHp(), 0));


        if (player.getHp() <= 0) {
            System.out.println("You died!");
        }
    }

    protected void killedMonster(){
        System.out.println("You defeated the " + monster.getName() + "!");

        Item loot = monster.rollLoot();
        if (loot != null) {
            System.out.println("You received: " + loot.getName());
            player.getInventory().addItem(loot);
        } else {
            System.out.println("The monster dropped nothing.");
        }
    }
}
