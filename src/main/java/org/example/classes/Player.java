package org.example.classes;

import jakarta.persistence.*;

import java.util.List;

import org.example.classes.items.Inventory;
import org.example.classes.items.Item;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.consumables.scrolls.RoomScroll;
import org.example.classes.items.consumables.scrolls.ScrollBase;
import org.example.classes.items.weapons.WeaponBase;
import org.example.classes.jokers.Joker;
import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.cells.PlayerCell;
import org.example.classes.singleton.CurrentRoom;
import org.example.classes.singleton.CurrentUser;
import org.example.utils.PlayerCellConverter;

@Entity
@Table(name = "Player")
public class Player {
    @Id
    @Column(name = "id")
    private int id;

    private String name;
    private String username;
    
    @Column(nullable = false)
    private String password;
    private int hp;
    private String currentRoom;
    @Convert(converter = PlayerCellConverter.class)
    private PlayerCell playerCell = new PlayerCell(new Coordinates(1, 1));
    private Inventory inventory = new Inventory();
    private WeaponBase equippedWeapon;
    private ArmorBase equippedArmor;

    public Player() {}

    public Player(int id, String name, String username, int hp, String currentRoom2) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.hp = hp;
        this.currentRoom = currentRoom2;
    }


    public void equipWeapon(WeaponBase weapon) {
        this.equippedWeapon = weapon;
        System.out.println("You have equipped: " + weapon.getName());
    }
    public Player(int id, String name, String username, String password, int hp, String currentRoom2, PlayerCell playerCell) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.hp = hp;
        this.currentRoom = currentRoom2;
        this.playerCell = playerCell;
        this.inventory = new Inventory();
        this.equippedWeapon = null; // Initially no weapon equipped
        this.equippedArmor = null; // Initially no armor equipped
    }

    public WeaponBase getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return this.hp;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }
    public String getCurrentRoom() {
        return this.currentRoom;
    }

    public void setPlayerCell(PlayerCell playerCell) {
        this.playerCell = playerCell;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public PlayerCell getPlayerCell(){
        return this.playerCell;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void equipArmor(ArmorBase armor) {
        this.equippedArmor = armor;
        System.out.println("You have equipped: " + armor.getName());
    }

    public ArmorBase getEquippedArmor() {
        return equippedArmor;
    }

    public void equipItemByNumber(int index) {
        List<Item> items = inventory.getItems();
        if (index < 1 || index > items.size()) {
            System.out.println("Invalid item number.");
            return;
        }

        Item item = items.get(index - 1);

        switch (item) {
            case WeaponBase weapon:
                equipWeapon(weapon);
                break;
            case ArmorBase armor:
                equipArmor(armor);
                break;
            default:
                System.out.println("You can't equip that item.");
        }
    }

    public void useItemByNumber(int index) {
        List<Item> items = inventory.getItems();
        if (index < 1 || index > items.size()) {
            System.out.println("Invalid item number.");
            return;
        }

        Item item = items.get(index - 1);
        switch (item) {
            case ScrollBase<?> scroll:
                if (item instanceof RoomScroll roomScroll) {
                    roomScroll.cast();
                    if (roomScroll.getAmount() <= 0) {
                        CurrentUser.getInstance().getCurrentPlayer().getInventory().removeItem(roomScroll);
                        System.out.println("The scroll crumbles to dust after being used up.");
                    }
                } else {
                    System.out.println("You can't use this scroll outside of battle");
                }
                break;
            case Joker joker:
                joker.useJoker(CurrentRoom.getInstance().getCurrentRoom());
                inventory.removeItem(item); 
                break;
            default:
                System.out.println("That item can't be used right now.");
                break;
        }
    }
}
