package thread;

import java.util.Random;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo1 {
    // Java8引入，StampedLock可以认为是读写锁的改进版本，采用乐观加锁机制
    private final static StampedLock s1 = new StampedLock();
    private static Point point = new Point();

    public static void main(String[] args) {
        // 写入线程
        Runnable mRunnable = new Runnable() {

            @Override
            public void run() {
                point.move(new Random().nextInt(100), new Random().nextInt(100));
            }
        };
        // 读取线程
        Runnable rRunnable = new Runnable() {

            @Override
            public void run() {
                point.distanceFromOrigin();
            }
        };
        // 写入
        for (int i = 0; i < 20; i++) {
            new Thread(mRunnable).start();
        }
        // 读取
        for (int i = 0; i < 20; i++) {
            new Thread(rRunnable).start();
        }
    }

    // 来自JDK文档
    public static class Point {
        private double x, y;

        public void move(double deltaX, double deltaY) {
            // 上一个排他锁
            long stamp = s1.writeLock();
            try {
                x = deltaX;
                y = deltaY;
            } finally {
                s1.unlockWrite(stamp);
            }
        }

        public void distanceFromOrigin() {
            // tryOptimisticRead方法尝试一个乐观读，返回一个邮戳，作为这一次锁获取的凭证
            long stamp = s1.tryOptimisticRead();
            // 将全部变量拷贝到方法体栈内
            double currentX = x, currentY = y;
            // 判断stamp是否在读过程发生期间被修改
            // 如果没有被更改，则读取有效
            // 如果stamp是不可用的，可以如CAS操作一样，循环使用乐观读
            // 或者升级锁的级别，升级为悲观锁
            if (!s1.validate(stamp)) { //重点
                // 获取悲观的读锁，进一步读取数据，此时线程可能被挂起【挂起使用的是Unsafe.park()方法】
                // park方法遇到线程中断会直接返回。可能存在park的线程再次进入循环，如果不能退出，将占用大量CPU资源
                stamp = s1.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    s1.unlockRead(stamp);
                }
            }
            System.out.println(currentX * currentX + currentY * currentY);

        }
    }
}
