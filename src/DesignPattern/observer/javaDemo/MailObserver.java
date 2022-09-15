package DesignPattern.observer.javaDemo;


import java.util.Observable;
import java.util.Observer;

//观察者模式
public class MailObserver implements Observer {

    private String userInfo;

    public MailObserver(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("发送邮件" + arg + "消息" + userInfo);
    }

}
