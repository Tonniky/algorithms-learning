package thread;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest4 {
    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[3];
        StampedLock sl = new StampedLock();

        //启动一个写线程长时间占用锁
        new Thread(() -> {
            long stamp = sl.writeLock();
            LockSupport.parkNanos(60000000000000L);
            sl.unlock(stamp);
        }).start();
        Thread.sleep(100);

        //启动三个读线程
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(() -> {
                long stamp = sl.readLock();
                System.out.println(Thread.currentThread().getName() + "获得锁.");
                sl.unlock(stamp);
            });
            threads[i].start();
        }
        //5秒后等到三个线程因写锁被占用导致挂起后进行中断
        Thread.sleep(5000);
        for (int i = 0 ; i < 3; i++) {
            threads[i].interrupt();
        }
    }

}
