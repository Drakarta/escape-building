package org.example.classes.combat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.example.classes.monsters.*;

public class RandomCombat {
    public static Monster createRandomMonster() {
        List<Monster> monsters = Arrays.asList(
            new Goblin(), new Ant(), new Alexander(), new Thijs(), new Worker()
        );
        Collections.shuffle(monsters);
        return monsters.get(0);
    }
}

