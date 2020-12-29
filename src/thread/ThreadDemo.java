package thread;

import org.junit.runner.notification.RunListener;

public class ThreadDemo {

    public static void main(String[] args) {

        //

        new RunThread1().start();
        new RunThread2().start();
    }

    public class RunThread1 extends Thread{

        @Override
        public synchronized void run() {
            this.getThreadGroup().getName();
            Thread.currentThread().getName();
            Thread.clss.notify();
        }
    }

    public class RunThread2 extends Thread {

        public synchronized void run() {
            try {
                Thread.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
