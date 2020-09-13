package DesignPattern.SingleTon;

public class Singleton3 {
    public static volatile Singleton3 singleton3 = null;
    public Singleton3() {}
    public Singleton3 getInstance() {
        if (singleton3 == null) {
            synchronized (Singleton3.class) {
                if (singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
