package org.example.classes.observers.interfaces;

import org.example.classes.questions.Question;

public interface QuestionObject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
