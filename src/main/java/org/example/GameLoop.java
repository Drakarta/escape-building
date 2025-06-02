package org.example;

import java.util.Scanner;

import org.example.classes.Player;
import org.example.classes.Status;
import org.example.classes.combat.CombatLoop;
import org.example.classes.monsters.Goblin;
import org.example.classes.monsters.Monster;
import org.example.classes.rooms.DoorLink;
import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;
import org.example.classes.singleton.DoorList;
import org.example.classes.singleton.RoomList;


public class GameLoop {
    Scanner scanner = new Scanner(System.in);
    public GameLoop() {

    }

    public void start() {
        
        while (true) {
            CurrentRoom.getInstance().setCurrentRoom(RoomList.getInstance().getRoomByName(CurrentUser.getInstance().getCurrentPlayer().getCurrentRoom()));
            CurrentRoom.getInstance().getCurrentRoom().displayRoom();

            String input = scanner.nextLine().trim();
            handleInput(input);
            
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }
        }
        scanner.close();
    }

    public void handleInput(String input) {
        switch (input.toLowerCase()) {
            case "w", "a", "s", "d", "e":
                CurrentRoom.getInstance().getCurrentRoom().getPlayerMovement(input);

                if (Math.random() < 1) { //chance of encounter
                    Player player = CurrentUser.getInstance().getCurrentPlayer();
                    Monster goblin = new Goblin();
                    CombatLoop combat = new CombatLoop(player, goblin, scanner);
                    combat.startCombat();
                }
                break;
            case "status":
                Status status = new Status();
                String currentStatus = status.getStatus(CurrentUser.getInstance().getCurrentPlayer());
                System.out.println(currentStatus);
                break;
            case "doorlist":
                for (DoorLink doorLink : DoorList.getInstance().getAllDoorLinks()) {
                    System.out.printf("Door from '%s' to '%s' [%s] - Locked: %s%n",
                            doorLink.getSourceRoom(),
                            doorLink.getTargetRoom(),
                            doorLink.getDoor().getDoorPosition(),
                            doorLink.getDoor().isLocked());
                }
                break;
            case "inventory":
                while (true) {
                    Player player = CurrentUser.getInstance().getCurrentPlayer();
                    player.getInventory().printInventory(player);
                    System.out.println("Type 'equip <#>' to equip, or 'back' to exit inventory.");

                    String invInput = scanner.nextLine().trim().toLowerCase();

                    if (invInput.startsWith("equip ")) {
                        try {
                            int num = Integer.parseInt(invInput.split(" ")[1]);
                            player.equipItemByNumber(num);
                        } catch (Exception e) {
                            System.out.println("Invalid command. Try 'equip 1'");
                        }
                    } else if (invInput.equals("back")) {
                        break;
                    } else {
                        System.out.println("Unknown command. Try 'equip <#>' or 'back'.");
                    }
                }
            break;
        }
    }
}

