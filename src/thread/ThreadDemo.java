package thread;

public class ThreadDemo {

    public static void main(String[] args) {

        //

        new RunThread1().start();
        new RunThread2().start();
    }

    public static class RunThread1 extends Thread{

        @Override
        public synchronized void run() {
            this.getThreadGroup().getName();
            Thread.currentThread().getName();
            Thread.class.notify();
        }
    }

    public static class RunThread2 extends Thread {

        @Override
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
