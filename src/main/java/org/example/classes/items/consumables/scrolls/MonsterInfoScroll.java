package org.example.classes.items.consumables.scrolls;

import org.example.classes.monsters.*;

public class MonsterInfoScroll extends ScrollBase{

    public MonsterInfoScroll(String name, String spellDescription) {
        super("Monster info scroll", "This magical scroll will help you with information about the monster you are currently facing", 8);
    }

    @Override
    public void cast(Monster monster) {
        monster.displayInfo();
    }  
}
