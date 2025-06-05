package org.example;

import org.example.classes.Player;
import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.cells.PlayerCell;
import org.example.utils.HibernateUtil;

public class Main{
    public static void main(String[] args) throws Exception {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Player player = new Player(4, "ant", "ant123", "securePass123", 3, "room1", new PlayerCell(new Coordinates(0, 0)));
        hibernateUtil.delete(player);
        hibernateUtil.create(player);
        Object test = hibernateUtil.read("FROM Player WHERE id = 4", Player.class);
        System.out.println(test);

        hibernateUtil.shutdown();
        // Game game = new Game();
        // game.gameloop();
    }
}