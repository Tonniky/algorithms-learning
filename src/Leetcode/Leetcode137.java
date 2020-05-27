package Leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode137 {
    public int singleNumber(int[] nums) {
        HashSet<Long> set = new HashSet<>();
        long temp = 0;
        long cn = 0;
        for (int num: nums) {
            if(!set.contains(num)) {
                cn += num;
                set.add((long)num);
            }
            temp += num;
        }
        return (int)((3 * cn - temp) / 2);
    }

    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (int k: map.keySet()) {
            if (map.get(k) == 1)
                return k;
        }
        return -1;
    }



    }
