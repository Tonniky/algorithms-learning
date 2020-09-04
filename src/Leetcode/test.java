package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class test {
    public void findTwo() {
        Set<Integer> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        int[] in = {4,2,4,2,5};
            for (int i = 0 ; i < 5; i++) {
                int s = in[i];
            if (set.contains(s)) {
                res.append(s + " ");
            } else {
                set.add(s);
            }
        }
            res.append(1);
        res.deleteCharAt(res.length() - 1);
    }

    public static void main(String[] args) {
        test ou = new test();
        ou.findTwo();
    }

}
