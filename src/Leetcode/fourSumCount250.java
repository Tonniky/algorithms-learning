package Leetcode;
import java.util.*;

public class fourSumCount250 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int res = A[i] + B[j];
                map.put(res, map.getOrDefault(res,0) + 1);
            }
        }
        int res = 0;
        for (int m = 0; m < C.length; m++) {
            for (int n = 0; n < D.length; n++) {
                int c = -(C[m] + D[n]);
                if(map.containsKey(c)) {
                    res += map.get(c);
                }
            }
        }
        return res;
    }
    }
