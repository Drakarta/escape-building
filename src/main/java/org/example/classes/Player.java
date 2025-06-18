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
import org.example.utils.SaveFile;
import org.example.utils.databaseconverters.ArmorBaseConverter;
import org.example.utils.databaseconverters.InventoryConverter;
import org.example.utils.databaseconverters.PlayerCellConverter;
import org.example.utils.databaseconverters.SaveFileConverter;
import org.example.utils.databaseconverters.WeaponBaseConverter;

@Entity
@Table(name = "players")
public class Player {
    @Id
    private String username;
    private String password;
    private int hp = 100;
    private int maxHp = 100;
    private String currentRoom = "Start Room";
    @Convert(converter = PlayerCellConverter.class)
    private PlayerCell playerCell = new PlayerCell(new Coordinates(1, 1));
    @Convert(converter = InventoryConverter.class)
    private Inventory inventory = new Inventory();
    @Convert(converter = WeaponBaseConverter.class)
    private WeaponBase equippedWeapon = null; 
    @Convert(converter = ArmorBaseConverter.class)
    private ArmorBase equippedArmor = null;
    @Convert(converter = SaveFileConverter.class)
    private SaveFile saveFile;

    public Player() {}

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Player(String username, String password, int hp, String currentRoom2, PlayerCell playerCell) {
        this.username = username;
        this.password = password;
        this.hp = hp;
        this.currentRoom = currentRoom2;
        this.playerCell = playerCell;
        this.inventory = new Inventory();
        this.equippedWeapon = null; // Initially no weapon equipped
        this.equippedArmor = null; // Initially no armor equipped
    }
    
    public void equipWeapon(WeaponBase weapon) {
        this.equippedWeapon = weapon;
        System.out.println("You have equipped: " + weapon.getName());
    }

    public WeaponBase getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setHp(int hp) {
        if (hp > maxHp) {
            this.hp = maxHp;
        } else {
            this.hp = hp;
        }
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

    public SaveFile getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(SaveFile saveFile2) {
        this.saveFile = saveFile2;
    }
}
