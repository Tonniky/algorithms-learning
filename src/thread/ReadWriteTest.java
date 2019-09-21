package thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest {
//    同一个线程中，在没有释放读锁的情况下，就去申请写锁，这属于锁升级，ReentrantReadWriteLock是不支持的。
    public static void main(String[] args) {
        ReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.readLock().lock();
        System.out.println("get readLock.");
        rtLock.writeLock().lock();
        System.out.println("blocking");

    }
//    同一个线程中，在没有释放写锁的情况下，就去申请读锁，这属于锁降级，ReentrantReadWriteLock是支持的
//    public static void main(String[] args) {
//        ReadWriteLock rtLock = new ReentrantReadWriteLock();
//        rtLock.writeLock().lock();
//        System.out.println("writeLock");
//        rtLock.readLock().lock();
//        System.out.println("get read lock");
//    }


}
