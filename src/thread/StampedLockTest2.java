package thread;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest2 {
    public static void main(String[] args) {

        StampedLock sl = new StampedLock();
        long stamp1 = sl.readLock();
        long stamp2 = sl.readLock();
        System.out.println(stamp1 + ".................." + stamp2);
        sl.unlock(stamp1);
        sl.unlock(stamp2);

        stamp1 = sl.writeLock();
        stamp2 = sl.writeLock();
        System.out.println(stamp1 + ".................." + stamp2);
        sl.unlock(stamp1);
        sl.unlock(stamp2);
    }
}
