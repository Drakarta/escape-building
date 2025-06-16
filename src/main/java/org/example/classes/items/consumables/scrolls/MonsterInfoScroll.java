package org.example.classes.items.consumables.scrolls;

import org.example.classes.monsters.*;

public class MonsterInfoScroll extends ScrollBase<Monster> {
    public MonsterInfoScroll(int amount) {
        super("Monster info scroll", "This magical scroll will help you with information about the monster you are currently facing" , amount);
    }

    @Override
    public void cast(Monster monster) {
        monster.displayInfo();
        decreaseAmount();
    }
}
