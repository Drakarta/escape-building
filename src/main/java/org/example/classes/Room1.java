package org.example.classes;

import java.util.Scanner;
//import java.util.random.RandomGenerator;

public abstract class Room1 {

    //protected RandomGenerator random = RandomGenerator.getDefault();
    protected Scanner scanner = new Scanner(System.in);

    protected int width;
    protected int height;

    protected int playerX;
    protected int playerY;

    protected int questionX;
    protected int questionY;

    protected int doorX;
    protected int doorY;
    protected int doorWall;

    protected int prevDoorX;
    protected int prevDoorY;
    protected int prevDoorWall;
    protected int prevExitWall = -1;

    protected boolean doorUnlocked = false;

    public final void start() {
        generateRoom();
        System.out.println(description());
        pause(1000);

        while (true) {
            
            clearScreen();
            drawRoom();

            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) continue;
            char move = input.charAt(0);

            handleInput(move);

            if (isPlayerThroughDoor()) {
                prevExitWall = doorWall;
                showPathway();
                //generateRoom();
                clearScreen();
                System.out.println(description());
                pause(1000);
            }
        }
    }

    protected void handleInput(char move) {
        int newX = playerX;
        int newY = playerY;
    
        switch (move) {
            case 'w':
                if ((playerY > 0) || (playerY == 0 && doorWall == 0 && playerX == doorX && doorUnlocked)) newY--;
                break;
            case 's':
                if ((playerY < height - 1) || (playerY == height - 1 && doorWall == 1 && playerX == doorX && doorUnlocked)) newY++;
                break;
            case 'a':
                if ((playerX > 0) || (playerX == 0 && doorWall == 2 && playerY == doorY && doorUnlocked)) newX--;
                break;
            case 'd':
                if ((playerX < width - 1) || (playerX == width - 1 && doorWall == 3 && playerY == doorY && doorUnlocked)) newX++;
                break;
            case 'e':
                if (isAdjacent(questionX, questionY)) {
                    interactWithQuestion();
                }  else if (isAdjacent(prevDoorX, prevDoorY)) {
                    interactWithPrevDoor();
                } else if (isAdjacent(doorX, doorY)) {
                    interactWithDoor();
                }
                break;
            case 'q':
                clearScreen();
                System.exit(0);
                return;
        }

        if (!(newX == questionX && newY == questionY)) {
            playerX = newX;
            playerY = newY;
        }
    }

    protected String description() {
        String description = "Test";
        return description;
    }
    
    protected boolean isAdjacent(int x, int y) {
        int dx = Math.abs(playerX - x);
        int dy = Math.abs(playerY - y);
        return (dx + dy == 1); 
    }
    
    protected void interactWithQuestion() {
        System.out.println("Hier moeten de vragen komen, dit is een temp");
        System.out.println("Type 1 om de deur te openen");
        String answer = scanner.nextLine();
    
        if (answer.trim().equals("1")) {
            System.out.println("Deur open");
            doorUnlocked = true;
            pause(1000);
        } else {
            System.out.println("Hoe krijg je dit voor elkaar");
            pause(1000);
        }
    }
    
    protected void interactWithPrevDoor() {
        System.out.println("Hier kom je vandaan, geen rede om terug te gaan");
        pause(1000);
    }

    protected void interactWithDoor() {
        if(doorUnlocked) {
            System.out.println("De deur is open");
        } else {
            System.out.println("Deze deur is gesloten. Ik vraag me af hoe ik het open krijg");
        }
        pause(1000);
    }

    protected boolean isPlayerThroughDoor() {
        return (doorWall == 0 && playerY < 0) ||
                (doorWall == 1 && playerY >= height) ||
                (doorWall == 2 && playerX < 0) ||
                (doorWall == 3 && playerX >= width);
    }

    protected void generateRoom() {
        System.out.println("generateRoom() called");
    width = 5;
    height = 3;

    playerX = 1;
    playerY = 1;

    questionX = 1;
    questionY = 2;

    doorX = 2;
    doorY = 1;
    doorWall = 3;

    prevDoorX = 0;
    prevDoorY = 1;
    prevDoorWall = 2;

    doorUnlocked = false;
}



    protected void drawRoom() {
        System.out.print("+");
        for (int x = 0; x < width; x++) {
            if (doorWall == 0 && doorX == x) 
                System.out.print("D");
            else if (prevDoorWall == 0 && prevDoorX == x)  
                System.out.print("L");
            else 
                System.out.print("-");
        }
        System.out.println("+");
    
        for (int y = 0; y < height; y++) {
            if (doorWall == 2 && doorY == y) 
                System.out.print("D");
            else if (prevDoorWall == 2 && prevDoorY == y)  
                System.out.print("L");
            else 
                System.out.print("|");
    
            for (int x = 0; x < width; x++) {
                if (x == playerX && y == playerY)
                    System.out.print("@");
                else if (x == questionX && y == questionY)
                    System.out.print("?");
                else
                    System.out.print(" ");
            }
    
            if (doorWall == 3 && doorY == y) 
                System.out.print("D");
            else if (prevDoorWall == 3 && prevDoorY == y)  
                System.out.print("L");
            else 
                System.out.print("|");
            System.out.println();
        }

        System.out.print("+");
        for (int x = 0; x < width; x++) {
            if (doorWall == 1 && doorX == x) 
                System.out.print("D");
            else if (prevDoorWall == 1 && prevDoorX == x)  
                System.out.print("L");
            else 
                System.out.print("-");
        }
        System.out.println("+");
    }
    
    protected void showPathway() {
        clearScreen();
        System.out.println();
        if (doorWall == 0 || doorWall == 1) {
            for (int i = 0; i < 3; i++) System.out.println("|     |");
            System.out.println("|  @  |");
        } else {
            for (int i = 0; i < 5; i++) System.out.print("-");
            System.out.println("\n@");
            for (int i = 0; i < 5; i++) System.out.print("-");
        }

        pause(1000);
    }

    protected void clearScreen() {
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }

    protected void pause(int milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
