package DesignPattern.observer.javaDemo;


import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ChatObserver implements Observer {

    private Executor executors = Executors.newFixedThreadPool(3);

    private String userInfo;

    public ChatObserver(String userInfo) {
        this.userInfo = userInfo;
    }


    @Override
    public void update(Observable o, Object arg) {
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.print("使用WeChat传递消息" + arg + "用户:" + userInfo);
            }
        });
    }
}
