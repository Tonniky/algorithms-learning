package thread;

import java.util.concurrent.Callable;

/**
 * 线程2
 */
public class Thread2 implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
        return "本条数据来自线程2";
    }
}