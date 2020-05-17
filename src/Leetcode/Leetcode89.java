package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>()
        {{add(0);}};
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() -1; j >= 0; j--) {
                res.add(count + res.get(j));
            }
            count <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode89 out = new Leetcode89();
        List<Integer> test = out.grayCode(2);
        System.out.print(test);
    }
}
