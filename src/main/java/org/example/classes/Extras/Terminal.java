package org.example.classes.Extras;

public class Terminal {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String PURPLE = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String BOLD = "\033[1m";

    public static void clearScreen() {
        System.out.println("\033[2J\033[H");
        System.out.flush();
    }

    public static void pauseBriefly() {
        try {
            Thread.sleep(1500); 
        }  catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
    }
}
