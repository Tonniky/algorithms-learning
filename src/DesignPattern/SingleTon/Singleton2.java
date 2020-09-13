package DesignPattern.SingleTon;

public class Singleton2 {
    private static Singleton2 singleton = null;
    public Singleton2() {};
    public synchronized Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
