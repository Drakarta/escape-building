package org.example.classes;

import jakarta.persistence.*;

import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.cells.PlayerCell;
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
    private PlayerCell playerCell;

    public Player() {}

    public Player(int id, String name, String username, int hp, String currentRoom2) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.hp = hp;
        this.currentRoom = currentRoom2;
        this.playerCell = new PlayerCell(new Coordinates(2, 2));
    }
    public Player(int id, String name, String username, String password, int hp, String currentRoom2, PlayerCell playerCell) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.hp = hp;
        this.currentRoom = currentRoom2;
        this.playerCell = playerCell;
    }

    public Player(int id, String name, String username, int hp, String currentRoom2, PlayerCell playerCell) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.hp = hp;
        this.currentRoom = currentRoom2;
        this.playerCell = playerCell;
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

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public PlayerCell getPlayerCell(){
        return this.playerCell;
    }
}