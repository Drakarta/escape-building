package org.example.classes;

import java.util.Scanner;

public class Game {
    public static void gameplayLoop(){
        Status status = new Status();
        while(true){
            System.out.println("What do you want to do?");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            switch(input.toLowerCase()){
                case "status":
                    System.out.println(status.getStatus(CurrentUser.getInstance().getCurrentPlayer()));
                    break;
            }
        }
    }
}
