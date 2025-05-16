package org.example;

import org.example.utils.DatabaseConnection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(DatabaseConnection.execute("SELECT * FROM Room;", List.of()));
    }
}