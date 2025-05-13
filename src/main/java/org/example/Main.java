package org.example;
import org.example.classes.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        new Room().start();
        System.out.println("From what table do you want to see the data?");
        Scanner scanner = new Scanner(System.in);
        String tableName = scanner.nextLine();

        DatabaseConnection.searchFor(tableName);
    }
}