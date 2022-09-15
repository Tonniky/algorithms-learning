package DesignPattern.observer;

/**
 * 观察者
 **/

public interface Observer {

    void update();

    void wantTo();

    void updateContent(String content);

}
