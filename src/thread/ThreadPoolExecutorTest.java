package thread;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    private static int produceTaskSleepTime = 2;

    private static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {

        // 构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 1; i <= produceTaskMaxNumber; i++) {
            try {
                String task = "task-- " + i;
                System.out.println("创建任务并提交到线程池中：" + task);
                threadPool.execute(new ThreadPoolTask(task));
                System.out.println("线程池中线程数目："+threadPool.getPoolSize()+"，队列中等待执行的任务数目："+
                        threadPool.getQueue().size()+"，已执行完毕的任务数目："+threadPool.getCompletedTaskCount());

                Thread.sleep(produceTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadPoolTask implements Runnable, Serializable {

    private Object attachData;

    ThreadPoolTask(Object tasks) {
        this.attachData = tasks;
    }

    public void run() {

        System.out.println("开始执行任务：" + attachData);

        attachData = null;
    }

    public Object getTask() {
        return this.attachData;
    }
}

