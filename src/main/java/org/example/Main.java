package org.example;

import org.example.classes.Game;
import org.example.classes.rooms.RoomList;

//Heb nog geen subklasses
public class Main{
    public static void main(String[] args) {
        new InitialiseRooms();
        RoomList roomList = RoomList.getInstance();
        GameLoop gameLoop = new GameLoop();
        gameLoop.start();
    }
}