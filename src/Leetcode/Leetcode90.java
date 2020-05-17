package Leetcode;

import javax.security.auth.login.AccountExpiredException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 1; i <= length; i++) {
            backTrack(nums, i, 0, new int[i], 0);
        }
        return res;
    }

    public void backTrack(int[] nums,int k, int start, int[] temp, int curIndex) {
        if (curIndex == k) {
            List<Integer> tempRes = new ArrayList<>();
            for (int i : temp)
                tempRes.add(i);
                res.add(tempRes);
                return;

        }

            for (int i = start; i < nums.length - k + curIndex + 1; i++) {
                if (i != start && nums[i] == nums[i - 1])
                    continue;
                temp[curIndex] = nums[i];
                backTrack(nums, k, i + 1, temp, curIndex + 1);
            }
    }

    public static void main(String[] args) {
        Leetcode90 out = new Leetcode90();
        int[] test = {1,2,2};
        out.subsetsWithDup(test);
    }

    }



