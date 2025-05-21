package org.example.classes.hints;

public class FunnyHint implements DisplayHint {
    private String hintText;

    public FunnyHint(String hintText) {
        this.hintText = hintText;
    }

    public String getHintText() {
        return this.hintText;
    }
}