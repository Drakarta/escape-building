package org.example.classes;

public class Player {
    private int id;
    private String name;
    private int hp;
    private int currentRoom;


    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp(){
        return this.hp;
    }

    public void setCurrentRoom(int currentRoom){
        this.currentRoom = currentRoom;
    }
    public int getCurrentRoom(){
        return this.currentRoom;
    }
}
