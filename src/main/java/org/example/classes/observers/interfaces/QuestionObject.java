package org.example.classes.observers.interfaces;


public interface QuestionObject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
