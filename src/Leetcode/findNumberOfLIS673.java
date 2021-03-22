package Leetcode;

import java.util.Arrays;

public class findNumberOfLIS673 {


    public int findNumberOfLIS1(int[] nums) {
        int N = nums.length;
        if (N < 1) {
            return N;
        }
        int[] lengths = new int[N];
        int[] counts = new int[N];
        Arrays.fill(counts, 1);
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (lengths[i] >= lengths[j]) {
                    lengths[j] = lengths[i] + 1;
                    counts[j] = counts[i] + 1;
                } else if (lengths[i] + 1 == lengths[j]){
                    counts[j] += counts[i];
                }
             }
        }

        int num = 0;
        int longest = 0;
        for (int i = 0; i < N; i++) {
            longest = Math.max(longest, lengths[i]);
        }
        for (int i = 0; i < N; i++) {
            if (longest == lengths[i]) {
                num += counts[i];
            }
        }
        return num;
    }


    

    }
