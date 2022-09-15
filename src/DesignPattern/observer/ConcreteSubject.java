package DesignPattern.observer;


/**
 * 具体的被观察者
 **/
public class ConcreteSubject extends Subject  {

    //具体业务
    public void doSomething() {
        super.notifyObservers();
    }



}
