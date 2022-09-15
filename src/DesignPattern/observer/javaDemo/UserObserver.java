package DesignPattern.observer.javaDemo;

import java.util.Observable;
// 被观察者
public class UserObserver extends Observable {

    public void addNotify(String content) {
        super.setChanged();
        super.notifyObservers(content);
    }

}
