package demo.package1;

public  class test8 {
    public < E > test8(E[] intputArr) {
        for (E in : intputArr) {
            System.out.printf("s", in);
        }
    }

    public static <T extends Comparable<T>> T ein(T x, T y, T z) {
        T max = x;
        if (max.compareTo(y) < 0) {
            max = y;
        }
        if(max.compareTo(z) < 0) {
            max = z;
        }
        return max;
    }




}
