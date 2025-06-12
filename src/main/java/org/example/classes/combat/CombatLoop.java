package org.example.classes.combat;

import org.example.classes.Player;
import org.example.classes.items.Item;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.consumables.potions.PotionBase;
import org.example.classes.items.consumables.scrolls.MonsterInfoScroll;
import org.example.classes.items.consumables.scrolls.RoomScroll;
import org.example.classes.items.consumables.scrolls.ScrollBase;
import org.example.classes.monsters.Monster;

import java.util.Scanner;

public class CombatLoop {
    private final Player player;
    private final Monster monster;
    private final Scanner scanner;
    private Item loot;
    

    public CombatLoop(Player player, Monster monster, Scanner scanner) {
        this.player = player;
        this.monster = monster;
        this.scanner = scanner;
    }

    public void startCombat() {
        monster.generateLoot();
        this.loot = monster.getRolledLoot();

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
                    System.out.println("Type the number of the item to use, or 'back' to cancel:");
                    String useInput = scanner.nextLine().trim().toLowerCase();

                    if (useInput.equals("back")) break;

                    try {
                        int itemNum = Integer.parseInt(useInput) - 1;
                        Item selectedItem = player.getInventory().getItems().get(itemNum);

                        if (selectedItem instanceof ScrollBase<?> scroll) {
                            if (selectedItem instanceof MonsterInfoScroll monsterScroll) {
                                monsterScroll.cast(monster);
                                if (monsterScroll.getAmount() <= 0) {
                                    player.getInventory().removeItem(monsterScroll);
                                    System.out.println("The scroll crumbles to dust after being used up.");
                                }
                            } else if (selectedItem instanceof RoomScroll roomScroll) {
                                roomScroll.cast();
                                if (roomScroll.getAmount() <= 0) {
                                    player.getInventory().removeItem(roomScroll);
                                    System.out.println("The scroll crumbles to dust after being used up.");
                                }
                            }
                        } else if (selectedItem instanceof PotionBase potion) {
                            potion.consume(player);
                            player.getInventory().removeItem(selectedItem); 
                        } else {
                            System.out.println("You can't use this item right now.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                    }
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
            try {
                Thread.sleep(3000);  // pause 1.5 seconds before exiting
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.exit(0);
        }
    }

    protected void killedMonster(){
        System.out.println("You defeated the " + monster.getName() + "!");

        if (loot != null) {
            System.out.println("You received: " + loot.getName());
            player.getInventory().addItem(loot);
        } else {
            System.out.println("The monster dropped nothing.");
        }
    }
}
