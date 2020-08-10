package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class fourSumCount454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 0 ; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sub = A[i] + B[j];
                map.put(sub, map.getOrDefault(sub,0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sub = -(C[i] + D[j]);
                if (map.containsKey(sub)) {
                    res += map.get(sub);
                }
            }
        }
        return res;
    }

}
