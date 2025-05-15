package org.example;
import javax.xml.crypto.Data;

import org.example.classes.*;
import org.example.classes.rooms.RoomList;

public class Main {
    public static void main(String[] args) {
        System.out.println(DatabaseConnection.query("SELECT * FROM Room;"));

    }
}