package thread;

public class ThreadLocalTest3 {
//    private static InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>();

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        private String _name = "";

        public MyRunnable(String name) {
            threadLocal.set((int) (Math.random() * 100D));

            System.out.println(name + " => " + Thread.currentThread().getName() + ":" + threadLocal.get());
        }

        //
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }
    }


    public static void main(String[] args) {
//        threadLocal.set(1);
//        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        Thread t1 = new Thread(new MyRunnable("R-A"), "A");
        Thread t2 = new Thread(new MyRunnable("R-B"), "B");

        t1.start();
        t2.start();
    }

}
