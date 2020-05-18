package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        vate(res, cur, 0, s, 0);
        return res;
    }

    public void vate(List<String> res, StringBuilder cur, int index, String s, int depth) {
        int len = cur.length();
        if (depth == 4) {
            if(index == s.length()) {
                cur.deleteCharAt(cur.length() - 1);
                res.add(cur.toString());
            }
            return;
        }

        for (int i = 0; i <= 3; i++) {
            if (index + i > s.length()) break;
            if(Integer.parseInt(s.substring(index, index + i)) > 255) break;
            int num = Integer.parseInt(s.substring(index, index + i));
            if (String.valueOf(num).length() != i) break;
            cur.append(s.substring(index, index + i));
            cur.append(".");
            vate(res, cur, index + i, s, depth + 1);
            cur.setLength(len);
        }
    }

    public static void main(String[] args) {
        Leetcode93 out = new Leetcode93();
        String s = "25525511135";
        List<String> test = out.restoreIpAddresses(s);
        System.out.print(test);
    }
    }
