package DesignPattern.observer;

/**
 * 具体观察者
 * */
public class ConcreteObserver implements Observer {

    private String name;

    private String content;

    private String weather;

    public ConcreteObserver(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public void update() {
        System.out.println("我就是测试一下哦");
    }

    @Override
    public void wantTo() {
        System.out.println( "谁" + name + "做" + content);
    }

    @Override
    public void updateContent(String content) {
        System.out.println("评论消息:" + content);
    }


}
