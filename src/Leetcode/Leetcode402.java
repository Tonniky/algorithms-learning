package Leetcode;

import java.util.LinkedList;

public class Leetcode402 {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chs = num.toCharArray();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            while (linkedList.size() > 0 && k > 0 && linkedList.peekLast() > chs[i]) {
                linkedList.removeLast();
                k -= 1;
            }
            linkedList.add(chs[i]);
        }

        for (int j = 0; j < k; j++) {
            linkedList.removeLast();
        }
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < linkedList.size(); i++) {
            if (flag == true && linkedList.get(i) == '0') {
                continue;
            }
            flag = false;
            res.append(linkedList.get(i));
        }
        if (res.length() == 0) {
            return "0";
        }
        return res.toString();
    }

    public String removeKdigits1(String num, int k) {
        int l = 0, len = num.length();
        int res[] = new int[len];
        for (int value : num.toCharArray()) {

            while (l > 0 && k > 0 && res[l - 1] > value) {
                l--;
                k--;
            }
            res[l++] = value;
        }
        while(k-- > 0 && l >0) {
        l--;
        }
        int start = 0;
        while (start < l && res[start] == '0')
            start ++;
        if ( l == start)
            return "0";
        return new String(res, start, l - 1);
    }

        public static void main(String[] args) {
        Leetcode402 out = new Leetcode402();
        String in = "1234567890";
        int k = 9;
        out.removeKdigits1(in, k);
    }
    }
