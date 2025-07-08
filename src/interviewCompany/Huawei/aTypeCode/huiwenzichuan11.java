package interviewCompany.Huawei.aTypeCode;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.HashMap;

public class huiwenzichuan11 {
    public static void main(String[] args) {
        String str = "abczcccddzz";
        System.out.println(getResult(str));
    }

    private static String getResult(String str) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character> half = new ArrayList<>();
        String mid = "";

        for (char c: count.keySet()) {
            int n = count.get(c);
            if (n >= 2) {
                for (int i = 0; i < n / 2; i++)
                    half.add(c);
            }

            if (n % 2 != 0 && ("".equals(mid)) || mid.compareTo(c + "") > 0) {
                mid = c + "";
            }
        }

        half.sort((a,b) -> a -b);
        StringBuilder sb = new StringBuilder();
        for (Character c: half) {
            sb.append(c);
        }
        return sb + mid + sb.reverse();


    }
}
