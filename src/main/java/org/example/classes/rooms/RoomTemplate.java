package org.example.classes.rooms;

public abstract class RoomTemplate {
    public final void play() {
        details();
        question();
        answer();
        result();
        feedback();
    }

    public abstract void details();
    public abstract void question();
    public abstract void answer();
    public abstract void result();
    public abstract void feedback();
}
