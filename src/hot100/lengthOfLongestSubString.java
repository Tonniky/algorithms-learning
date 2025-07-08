package hot100;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubString {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubString(s));
    }

    private static int lengthOfLongestSubString(String s) {
        Set<Character> set = new HashSet<Character>();
        int rk = -1, res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            res = Math.max(res, rk + 1 - i);
        }
        return res;

    }
}
