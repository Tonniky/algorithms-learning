package thread;

import java.util.concurrent.Callable;

/**
 * 线程1
 */
public class Thread1 implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
        return "本条数据来自线程1";
    }
}

