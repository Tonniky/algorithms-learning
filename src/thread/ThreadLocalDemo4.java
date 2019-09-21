package thread;

import java.util.Random;

public class ThreadLocalDemo4 {
    private static ThreadLocal<Integer> threadLocalInteger = new ThreadLocal<>();
    private static ThreadLocal<ScopeData> threadLocalData = new ThreadLocal<>();

    /**
     * @param args
     */
    public static void main(String[] args) {

        WordThread2 thread1 = new WordThread2(threadLocalInteger,threadLocalData);
        WordThread2 thread2 = new WordThread2(threadLocalInteger,threadLocalData);

        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName());
    }

}

class WordThread2 extends Thread {
    private ThreadLocal<Integer> mThreadLocalInteger;
    private ThreadLocal<ScopeData> mThreadLocalData;

    public WordThread2(ThreadLocal<Integer> threadLocalInteger, ThreadLocal<ScopeData> threadLocalData) {
        this.mThreadLocalInteger = threadLocalInteger;
        this.mThreadLocalData = threadLocalData;
    }

    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        super.run();
        System.out.println("WordThread:" + Thread.currentThread().getName());

        //设置数据
        int dataIn = new Random().nextInt(10);
        mThreadLocalInteger.set(dataIn);
        System.out.println(Thread.currentThread().getName()+"dataIn"+dataIn);

        ScopeData scopeData = new ScopeData();
        scopeData.setName("xiaoming"+dataIn);
        scopeData.setAge(dataIn);
        System.out.println();


        mThreadLocalData.set(scopeData);

        // 获取数据
        int dataOut = mThreadLocalInteger.get();
        ScopeData scopeDataOut = mThreadLocalData.get();

        System.out.println(dataOut);
        System.out.println(scopeDataOut);

    }

}

    class ScopeData{

        private String name;
        private int age;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "ScopeData [name=" + name + ", age=" + age + "]";
        }
    }


