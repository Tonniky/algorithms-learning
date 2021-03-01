package Leetcode;

public class replaceSpaces0103 {
    public String replaceSpaces(String S, int length) {
        if (S == null || length == 0) {
            return S;
        }
        char[] chs = S.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chs[i] == ' ') {
                res.append("%20");
            } else {
                res.append(String.valueOf(chs[i]));
            }
        }
        return res.toString();
    }
    }
