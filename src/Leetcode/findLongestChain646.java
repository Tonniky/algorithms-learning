package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findLongestChain646 {

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1,2},{2,5},{3,8}};
        findLongestChain2(pairs);
    }

    //
    public static int findLongestChain3(int[][] pairs) {
        Arrays.sort(pairs);
        List<Integer> res = new ArrayList<>();
        for(int[] p : pairs) {
            int x = p[0], y = p[1];
            if (res.size() == 0 || y > res.get(res.size() - 1)) {
                res.add(y);
            } else {
                int index = binarySearch(res,x);
                res.add(index,Math.min(y,res.get(index)));
            }
        }
        return res.size();
    }

    public static int binarySearch2(List<Integer> arr, int idx) {
        int low = 0, high = arr.size() - 1;
        while(low < high) {
            int mid = low + (high - low) / 1;
            if (arr.get(mid) > idx){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     *
     */
    public int findLongestChains(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }



    // 
    public static int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        List<Integer> arr = new ArrayList<Integer>();
        for (int[] p : pairs) {
            int x = p[0], y = p[1];
            if (arr.isEmpty() || x > arr.get(arr.size() - 1)) {
                arr.add(y);
            } else {
                int idx = binarySearch(arr, x);
                arr.set(idx, Math.min(arr.get(idx), y));
            }
        }
        return arr.size();
    }

    public static int binarySearch(List<Integer> arr, int x) {
        int low = 0, high = arr.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}

