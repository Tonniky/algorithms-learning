package thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    //使用信号量控制只有固定线程来操作
    public static void main(String[] args) {
        Semaphore windows = new Semaphore(5);  // 声明5个窗口

        for (int i = 0; i < 8; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        windows.acquire();  // 占用窗口
                        System.out.println(Thread.currentThread().getName() + ": 开始买票");
                        sleep(2000);  // 睡2秒，模拟买票流程
                        System.out.println(Thread.currentThread().getName() + ": 购票成功");
                        windows.release();  // 释放窗口
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

}
