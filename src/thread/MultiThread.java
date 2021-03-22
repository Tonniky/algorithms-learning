//package thread;
//
//import java.util.Map;
//import java.util.Queue;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class MultiThread {
//
//    public static void main(String[] args) {
//        Map<Integer, Queue<String>> multiMap = new ConcurrentHashMap<>();
//        ThreadGroup group = new ThreadGroup("thread1");
//        ThreadLocal threadLocal = new ThreadLocal<>();
//        for (int i = 0; i < 10; i++) {
//            String str = "111";
////            multiMap.put(i,);
//            if (multiMap.get(i) != null) {
//                Queue<String> queue = new LinkedBlockingQueue<>();
//                queue.add(i + "big");
//                multiMap.put(i,queue);
//            } else {
//                multiMap.put(i, i + "big");
//            }
//        }
//
//
//        // 如何让线程只消费自己的组织
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(group, new Runnable() {
//
//                @Override
//                public void run() {
//                    String i = Thread.currentThread().getName();
//                    Queue<String> consumerQueue = multiMap.get(i);
//                    while(!consumerQueue.isEmpty()) {
//                      string s = multiMap.get(i).poll();
//                      System.out.println("对应的线程消费的数据:" + s);
//                    }
//                }
////                group.put(i, i);
//            }, "fulu").start();
//        }
//    }
//}
