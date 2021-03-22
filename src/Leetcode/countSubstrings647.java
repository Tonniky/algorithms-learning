package Leetcode;

public class countSubstrings647 {
    public int countSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int num = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int l = i * 2, r = i * 2 + i % 2;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                num++;
            }
        }
        return num;
    }


//    public int contSubstring2(String s) {
//
//    }



}
