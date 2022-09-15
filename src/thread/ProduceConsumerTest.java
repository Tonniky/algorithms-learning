package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceConsumerTest {

    private AtomicInteger index = new AtomicInteger(1);
    private ReentrantLock reentrantLock = new ReentrantLock();
    private BlockingQueue queue = new ArrayBlockingQueue(200);
    private static boolean flag = false;

    public static void main(String[] args) {

    }

    public class produce implements Runnable {

        @Override
        public void run() {
            while (index.intValue() < 200) {
                queue.add(index);
            }
            reentrantLock.lock();
            queue.add(index.incrementAndGet());
            flag = false;
            reentrantLock.unlock();
        }

    }






}
