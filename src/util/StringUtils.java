package util;

public class StringUtils {

    public static String useUtil(String s) {
        if (s.contains(".")) {
          return String.format("%.2f", s);
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "100";
        String str = useUtil(s);
        System.out.print(str);
    }
}
