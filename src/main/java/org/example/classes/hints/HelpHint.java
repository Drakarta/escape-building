package org.example.classes.hints;

public class HelpHint implements DisplayHint {
    private String hintText;

    public HelpHint(String hintText) {
        this.hintText = hintText;
    }

    public String getHintText() {
        return this.hintText;
    }
}