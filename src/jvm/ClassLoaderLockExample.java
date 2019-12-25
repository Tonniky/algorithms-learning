//package jvm;
//
//public class ClassLoaderLockExample {
//
//        static volatile boolean running = true;
//
//        public static void main(String[] args) throws Exception {
//            Thread thread = new LongRunningThread();
//            try {
//                thread.start();
//                System.out.println("Running, press any key to stop.");
//                System.in.read();
//            } finally {
//                running = false;
//                thread.join();
//            }
//        }
//
//}
//
