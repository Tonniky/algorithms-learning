//package jvm;
//
//
//    static final class LongRunningThread extends Thread {
//        @Override public void run() {
//            while(running) {
//                try {
//                    loadAndDiscard();
//                } catch (Throwable ex) {
//                    ex.printStackTrace();
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException ex) {
//                    System.out.println("Caught InterruptedException, shutting down.");
//                    running = false;
//                }
//            }
//        }
//    }
//
//ChildOnlyClassLoader