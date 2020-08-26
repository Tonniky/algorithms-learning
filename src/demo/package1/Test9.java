package demo.package1;

import java.util.List;

public class Test9<T> {
    private T t;

    public T getT() {
        return t;
    }
    public void add(T to) {
        this.t = to;
    }

    public static void getData(List<?> data) {

    }

    public static void getUperNumber(List<? extends Number> data) {

    }
}
