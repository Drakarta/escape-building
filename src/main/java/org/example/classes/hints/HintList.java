package org.example.classes.hints;

import java.util.ArrayList;

public class HintList {
    private ArrayList<DisplayHint> hintList = new ArrayList<>();
    public void addHint(DisplayHint hint){
        hintList.add(hint);
    }
    public ArrayList<DisplayHint> getHintList() {
        return hintList;
    }
}
