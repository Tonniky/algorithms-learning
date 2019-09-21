package thread;

import java.util.concurrent.CyclicBarrier;
//CylicBarrier 等线程全部就位，然后一起开始执行任务。
public class CylicBarrierResult {

        public static void main(String[] args) throws InterruptedException {

            System.out.println("主线程开始......");

            CyclicBarrier cb = new CyclicBarrier(2, new Runnable(){

                @Override
                public void run() {
                    System.out.println("子线程全部就位，开始执行制定任务......");
                    System.out.println("当前的线程是" + Thread.currentThread().getName());
                }
            });

            Thread t1 = new Thread(new CyclicBarrierTask(cb), "Thread-1");
            Thread t2 = new Thread(new CyclicBarrierTask(cb), "Thread-2");
            Thread t3 = new Thread(new CyclicBarrierTask(cb), "Thread-3");

            t1.start();
            t2.start();
            t3.start();
//            Thread.sleep(1000);
//            t1.interrupt();

            Thread.sleep(2000);
            System.out.println("主线程执行完毕");
        }
    }


