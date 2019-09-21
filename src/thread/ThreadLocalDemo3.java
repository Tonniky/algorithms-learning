package thread;

import java.util.Random;

public class ThreadLocalDemo3 {
    private static ThreadLocal<Integer> threadData = new ThreadLocal<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocalDemo thread1 = new ThreadLocalDemo(threadData);
        ThreadLocalDemo thread2 = new ThreadLocalDemo(threadData);

        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName() + " 执行完毕");
    }
}

class ThreadLocalDemo extends Thread {
    private ThreadLocal<Integer> mThreadData;

    public ThreadLocalDemo(ThreadLocal<Integer> threadData) {
        this.mThreadData = threadData;
    }

    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        super.run();
        int dataIn = new Random().nextInt(10);
        mThreadData.set(dataIn);
        System.out.println("WordThread:" + Thread.currentThread().getName()+"datain"+dataIn);
        // 获取数据
        int dataOut = mThreadData.get();
        System.out.println(dataOut);

    }

}
