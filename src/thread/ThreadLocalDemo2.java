package thread;

import java.util.*;
// ThreadLocal   可以隔离各家算法的统计数据，互不干扰！
public class ThreadLocalDemo2 {

        private static Map<Thread, Integer> threadData = new HashMap<>();

        /**
         * @param args
         */
        public static void main(String[] args) {

            WordThread thread1 = new WordThread(threadData);
            WordThread thread2 = new WordThread(threadData);

            thread1.start();
            thread2.start();

            System.out.println(Thread.currentThread().getName()+" 执行完毕");

        }

    }

    class WordThread extends Thread {
        private Map<Thread, Integer> mThreadData;

        public WordThread(Map<Thread, Integer> threadData) {
            this.mThreadData = threadData;
        }

        /* (non-Javadoc)
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            super.run();
            System.out.println("WordThread:" + Thread.currentThread().getName());

            int dataIn = new Random().nextInt(10);

            // 存放数据, 这里之所以加个锁，是因为个别情况下因为并发原因导致mThreadData.put()的 key突然变为其他线程，则会导致get错误，Map线程不安全，注意
            synchronized (mThreadData) {
                mThreadData.put(Thread.currentThread(), dataIn);
                System.out.print(Thread.currentThread() + "数字为"+ dataIn);
            }

            // 获取数据
            int dataOut = mThreadData.get(Thread.currentThread());
            System.out.println(dataOut);

        }

}
