package thread;

import org.junit.Test;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest6 {
    private int shareObj = 0;
    private StampedLock lock = new StampedLock();

    private void add() {
        //添加写锁
        long stamp = lock.writeLock();
        try {
            shareObj++;
        }finally {
            lock.unlock(stamp);
        }
    }

    public void get() {

        //校验获取的锁是否成功
        boolean flag = false;
        //尝试获取五次锁
        for (int i = 0; i < 5 ; i++) {
            //尝试获取读锁
            long stamp = lock.tryOptimisticRead();
            if (lock.validate(stamp)) {
                flag = true;
                break;
            }else {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!flag) {
            //五次都没获取到，只好加一个悲观读锁了
            long stamp = lock.readLock();
            try {
                System.out.println(shareObj);
            } finally {
                lock.unlockRead(stamp);
            }
        } else {
            System.out.println(shareObj);
        }
    }

    @Test
    public void test1() {
        Runnable runnable1 = () -> {
            add();
        };
        Runnable runnable2 = () -> {
            get();
        };
        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable2).start();
        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable2).start();
        new Thread(runnable2).start();
    }

}
