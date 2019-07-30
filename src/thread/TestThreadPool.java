import thread.Thread1;
import thread.Thread2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestThreadPool{
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        //实例化类
        TestThreadPool testThreadPool = new TestThreadPool();
        //调用动态方法
        testThreadPool.threadPool();
    }

    public void threadPool() {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        //将Future包装进List，实现添加结果
        List<Future> resultList = new ArrayList<Future>();
        for (int i = 0; i < 3; i++) {
            System.out.println("线程池已提交：" + i);
            Future res1 = executorService.submit(thread1);
            Future res2 = executorService.submit(thread2);
            //将获取的结果添加进List
            resultList.add(res1);
            resultList.add(res2);
        }
        System.out.println("正在关闭线程池...");
        executorService.shutdown();

//        List<Callable<String>> list = new ArrayList<>();
//        try {
//            List<Future<String>> futures = executorService.invokeAll(list, 2, TimeUnit.SECONDS);
//            futures.get(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("线程池已关闭.");
        //executorService.shutdownNow();
        //线程池运行结束，打印结果
        for (int i = 0; i < resultList.size(); i++) {
            Future future = resultList.get(i);
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {}
        }
    }
}

