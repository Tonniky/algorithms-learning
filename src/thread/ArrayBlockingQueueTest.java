package thread;

import java.util.ConcurrentModificationException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ArrayBlockingQueueTest {
//      private static ConcurrentLinkedQueue<Food> queue = new ConcurrentLinkedQueue<>();
    private static ArrayBlockingQueue<Food> queue = new ArrayBlockingQueue<Food>(2);
//    private static ConcurrentLinkedQueue<Food> queue = new ConcurrentLinkedQueue<Food>();
//    private static LinkedBlockingQueue<Food> queue = new LinkedBlockingQueue<Food>(3);

    class Producer implements Runnable {

        @Override
        public void run() {
            Food food = new Food();
            food.setName("banana");
            try {
                queue.put(food);
//                queue.add(food);
                System.out.println(Thread.currentThread().getName() + "provider : " + food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                Food food = queue.take();
                System.out.println(Thread.currentThread().getName() + "consumer : " + food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0 ; i < 5 ; i++) {
            new Thread(new ArrayBlockingQueueTest().new Producer()).start();
        }

        new Thread(new ArrayBlockingQueueTest().new Consumer()).start();
        new Thread(new ArrayBlockingQueueTest().new Consumer()).start();
    }
}