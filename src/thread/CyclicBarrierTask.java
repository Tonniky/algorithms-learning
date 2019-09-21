package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTask implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "准备就绪");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "中断了......");
        } catch (BrokenBarrierException e) {
            System.out.println(Thread.currentThread().getName() + "抛出损坏异常....");
        }
    }
}




