package org.example.classes.items;

import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.consumables.potions.HealthPotion;
import org.example.classes.items.consumables.scrolls.MonsterInfoScroll;
import org.example.classes.items.consumables.scrolls.RoomScroll;
import org.example.classes.items.weapons.WeaponBase;
import org.example.classes.jokers.HintJoker;
import org.example.classes.jokers.KeyJoker;
import org.example.classes.singleton.CurrentUser;
import org.example.utils.Save;

public class StarterItems {

    public static void startingItems(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Do you want a 'KeyJoker', a 'HintJoker' or nothing?");
        String chosenJoker = scanner.nextLine();
        if (chosenJoker.equalsIgnoreCase("KeyJoker")) {
            CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new KeyJoker("KeyJoker"));
            System.out.println("You got a KeyJoker!");
        } else if(chosenJoker.equalsIgnoreCase("HintJoker")) {
            CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new HintJoker("HintJoker"));
            System.out.println("You got a HintJoker!");
        } else{
            System.out.println("You have chosen nothing like a true warrior!");
        }
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new WeaponBase("Wooden sword", 100, 50));
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new ArmorBase("Leather armor", 3, 5));
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new ArmorBase("Chainmail armor", 3, 4));
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new MonsterInfoScroll(2));
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new RoomScroll());
        CurrentUser.getInstance().getCurrentPlayer().getInventory().addItem(new HealthPotion(20));
        Save.saveGame();
    }
}
