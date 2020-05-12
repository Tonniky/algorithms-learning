package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode60 {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];  // 0! ,1! , ...,(n-1)!
        List<Integer> fac = new ArrayList<>(); //记录需要排列的所有数字
        fac.add(1);
        nums[0] =1;
        for(int i = 1; i < n; i++) {
            nums[i] = nums[i-1] * i;
            fac.add(i+1);
        }
        k--;

        //
        StringBuilder res = new StringBuilder();
        for(int i = n-1; i >= 0; i--) {
           int temp = k/nums[i];
           k -= temp * nums[i];
           res.append(fac.get(temp));
           fac.remove(temp);   //取完后，去掉该值
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Leetcode60 te = new Leetcode60();
        te.getPermutation(3,3);
    }


}
