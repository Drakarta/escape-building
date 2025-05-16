package org.example.classes;

public class Status {
    public String getStatus(Player player){
        return "Username: " + player.getUsername() + "\n"
                + "Current Room: " + player.getCurrentRoom() + "\n"
                + "Hp: " + player.getHp();
    }
}
