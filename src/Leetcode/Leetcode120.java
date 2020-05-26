package Leetcode;

import java.util.List;

public class Leetcode120 {
    //这种解法是错误的，只找到了局部解
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int sum = 0;
        sum = triangle.get(0).get(0);
        int p = 0;
        int len = triangle.size();
        if (len == 1)
            return sum;
        for (int i = 1; i < len; i++) {
            sum = sum + Math.min(triangle.get(i + 1).get(p),triangle.get(i).get(p + 1));
        }
        return sum;
    }

    //解决办法是全部遍历一遍。
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null) {
            return 0;
        }
        int[][] sum = new int[triangle.size()][triangle.size()];
        sum[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        if (triangle.size() == 1)
            return sum[0][0];
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    sum[i][j] = sum[i - 1][0] + triangle.get(i).get(j);
                }else if(j == i) {
                    sum[i][j] = sum[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    sum[i][j] = triangle.get(i).get(j) + Math.min(sum[i - 1][j - 1],sum[i - 1][j]);
                }
                if(i == triangle.size() - 1) {
                    res = Math.min(res, sum[i][j]);
                }
            }
        }
        return res;
    }


    }
