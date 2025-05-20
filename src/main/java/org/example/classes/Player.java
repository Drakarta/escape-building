package org.example.classes;

public class Player {
    private int id;
    private String name;
    private String username;
    private int hp;
    private String currentRoom;


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