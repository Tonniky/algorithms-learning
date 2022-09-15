package DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 *
 */
public abstract class Subject {

    private List<Observer> obsList = new ArrayList<>();

    public void addObserver(Observer observer) {
        obsList.add(observer);
    }

    public void delObserver(Observer observer) {
        obsList.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer: obsList) {
            observer.wantTo();
        }
    }



}
