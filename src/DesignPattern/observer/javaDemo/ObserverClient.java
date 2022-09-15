package DesignPattern.observer.javaDemo;

public class ObserverClient {

    // JDK的观察者模式推送。

    /**
     * ①、观察者和被观察者之间是抽象耦合
     *
     * 不管是增加观察者还是被观察者都非常容易扩展，在系统扩展方面会得心应手。
     *
     * ②、建立一套触发机制
     *
     * 被观察者变化引起观察者自动变化。但是需要注意的是，一个被观察者，多个观察者，Java的消息通知默认是顺序执行的，如果一个观察者卡住，会导致整个流程卡住，这就是同步阻塞。
     *
     * 所以实际开发中没有先后顺序的考虑使用异步，异步非阻塞除了能够实现代码解耦，还能充分利用硬件资源，提高代码的执行效率。
     *
     * 另外还有进程间的观察者模式，通常基于消息队列来实现，用于实现不同进程间的观察者和被观察者之间的交互。
     *
     * */

    /**
     * 应用场景：
     * ①、关联行为场景。
     *
     * ②、事件多级触发场景。
     *
     * ③、跨系统的消息交换场景， 如消息队列的处理机制。
     * */
    public static void main(String[] args) {
        UserObserver userObserver = new UserObserver();
        userObserver.addObserver(new SMSObserver("sms")); // 推模式
        userObserver.addObserver(new MailObserver("mail"));
        userObserver.addObserver(new ChatObserver("Chat"));
        userObserver.addNotify("张三"); // 拉模式
    }
}
