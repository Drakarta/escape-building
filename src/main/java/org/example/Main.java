package org.example;

import org.example.classes.Player;
import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.cells.PlayerCell;
import org.example.utils.HibernateUtil;

public class Main{
    public static void main(String[] args) throws Exception {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Player player = new Player(4, "ant", "ant123", "securePass123", 3, "room1", new PlayerCell(new Coordinates(0, 0)));
        hibernateUtil.create(player);

        hibernateUtil.shutdown();
        // Game game = new Game();
        // game.gameloop();
    }
}