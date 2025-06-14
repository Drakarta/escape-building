package org.example.classes.combat;

import org.example.classes.Player;
import org.example.classes.monsters.Monster;
import org.example.classes.observers.interfaces.QuestionObserver;
import org.example.classes.singleton.CurrentUser;

import java.util.Scanner;

public class CombatStarter implements QuestionObserver {
    public void startCombat() {
        Scanner scanner = new Scanner(System.in);
        Player player = CurrentUser.getInstance().getCurrentPlayer();
        Monster monster = RandomCombat.createRandomMonster();
        CombatLoop combat = new CombatLoop(player, monster, scanner);
        combat.startCombat();
    }

    @Override
    public void update(boolean trigger) {
        if (!trigger) {
            startCombat();
        }
    }
}
