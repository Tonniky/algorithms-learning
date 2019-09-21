package thread;

public class SynchronizedTest {
    public static synchronized void staticMethod() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println("staticMethod:" + i);
        }
    }

    public synchronized void normalMethod() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("normalMethod:" + i);
        }
    }

    public static void main(String[] args) {
        final SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedTest.normalMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "a");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SynchronizedTest.staticMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "b");

        thread1.start();
        thread.start();
    }
}
