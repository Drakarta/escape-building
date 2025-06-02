package org.example.classes;

import java.util.List;

import org.example.classes.items.Inventory;
import org.example.classes.items.Item;
import org.example.classes.items.armor.ArmorBase;
import org.example.classes.items.weapons.WeaponBase;
import org.example.classes.rooms.Coordinates;

import org.example.classes.rooms.cells.PlayerCell;

public class Player {
    private int id;
    private String name;
    private String username;
    private int hp;
    private String currentRoom;
    private PlayerCell playerCell;
    private Inventory inventory;
    private WeaponBase equippedWeapon;
    private ArmorBase equippedArmor;


    public Player(int id, String name, String username, int hp, String currentRoom2) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.hp = hp;
        this.currentRoom = currentRoom2;
        this.playerCell = new PlayerCell(new Coordinates(2, 2));
        this.inventory = new Inventory();
    }
    public Player(int id, String name, String username, int hp, String currentRoom2, PlayerCell playerCell) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.hp = hp;
        this.currentRoom = currentRoom2;
        this.playerCell = playerCell;
        this.inventory = new Inventory();
    }

    public void equipWeapon(WeaponBase weapon) {
        this.equippedWeapon = weapon;
        System.out.println("You have equipped: " + weapon.getName());
    }

    public WeaponBase getEquippedWeapon() {
        return equippedWeapon;
    }

    public void useEquippedWeapon() {
        if (equippedWeapon == null) {
            System.out.println("No weapon equipped.");
            return;
        }

        boolean used = equippedWeapon.use();
        if (used) {
            System.out.println("You used " + equippedWeapon.getName() + ". Remaining durability: " + equippedWeapon.getDurability());
        } else {
            System.out.println(equippedWeapon.getName() + " is broken!");
        }
    }

    public void setId(int id) {this.id = id;}
    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp(){
        return this.hp;
    }

    public void setCurrentRoom(String currentRoom){
        this.currentRoom = currentRoom;
    }
    public String getCurrentRoom(){
        return this.currentRoom;
    }

    public void setPlayerCell(PlayerCell playerCell){
        this.playerCell = playerCell;
    }
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

    if (item instanceof WeaponBase weapon) {
        equipWeapon(weapon);
    } else if (item instanceof ArmorBase armor) {
        equipArmor(armor);
    } else {
        System.out.println("You can't equip that item.");
    }
}

}