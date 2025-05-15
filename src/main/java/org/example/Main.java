package org.example;
import org.example.classes.*;
import java.util.Scanner;


//Heb nog geen subklasses
public class Main extends Room{
    public static void main(String[] args) {
        new Main().start();
        System.out.println("From what table do you want to see the data?");
        Scanner scanner = new Scanner(System.in);
        String tableName = scanner.nextLine();

        DatabaseConnection.searchFor(tableName);
    }
}