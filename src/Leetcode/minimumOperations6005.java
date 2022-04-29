package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class minimumOperations6005 {
    public static int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] str1 = s.toCharArray();
        int len1 = s.length();
        char[] str2 = t.toCharArray();
        int len2 = t.length();
        int sum = 0;
        for (int i = 0; i < len1; i++) {
            map.put(str1[i], map.getOrDefault(str1[i], 0) + 1);
        }
        for (int j = 0; j < len2; j++) {
            if (map.getOrDefault(str2[j], 0) > 0) {
                map.put(str2[j], map.get(str2[j]) - 1);
                sum++;
            }
        }
        int res = s.length() + t.length() - 2 * sum;
        return res;
    }

    public static void main(String[] args) {
       int res =  minSteps("leetcode", "coats");
       System.out.println(res);
    }
}
