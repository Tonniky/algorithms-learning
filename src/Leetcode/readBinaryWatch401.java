package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class readBinaryWatch401 {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if(count1(i) + count1(j) == num) {
                    res.add(String.valueOf(i) + ":" + (j < 10 ? "0" +
                            String.valueOf(j): String.valueOf(j)));
                }
            }
        }
        return res;
    }

    //计算二进制中1的个数
    int count1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    }




