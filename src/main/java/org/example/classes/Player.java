package org.example.classes;

import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.cells.PlayerCell;

public class Player {
    private int id;
    private String name;
    private String username;
    private int hp;
    private String currentRoom;
    private PlayerCell playercell;

    public Player(String name, String username, int hp, String currentRoom, PlayerCell playercell){
        this.name = name;
        this.username = username;
        this.hp = hp;
        this.currentRoom = currentRoom;
        this.playercell = playercell;
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
}