package DesignPattern.observer.javaDemo;

import java.util.Observable;
import java.util.Observer;

public class SMSObserver implements Observer {

    private String info;

    SMSObserver(String info) {
        this.info = info;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.print("发送SMS短信" + arg + "消息:" + info);
    }
}
