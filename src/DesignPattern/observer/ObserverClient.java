package DesignPattern.observer;

public class ObserverClient {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("Son", "我想出去玩");

        Observer observer2 = new ConcreteObserver("daughter", "我想买玩具");

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.delObserver(observer1);
        subject.doSomething();
    }
}
