package org.example.classes.combat;

import org.example.classes.Player;
import org.example.classes.monsters.Goblin;
import org.example.classes.monsters.Monster;
import org.example.classes.observers.interfaces.QuestionObserver;
import org.example.classes.singleton.CurrentUser;

import java.util.Scanner;

public class CombatStarter implements QuestionObserver {
    public void startCombatGoblin(){
        Scanner scanner = new Scanner(System.in);
        Player player = CurrentUser.getInstance().getCurrentPlayer();
        Monster goblin = new Goblin();
        CombatLoop combat = new CombatLoop(player, goblin, scanner);
        combat.startCombat();
    }

    @Override
    public void update(boolean trigger) {
        if(!trigger){
            startCombatGoblin();
        }
    }
}
