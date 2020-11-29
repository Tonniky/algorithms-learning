package Leetcode;
import java.util.*;

public class wiggleMaxLength376 {

    //
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        return 1 + Math.max(cal(nums, 0, true), cal(nums, 0, false));
    }

    public int cal(int[] nums, int index, boolean isUp) {
        int maxCount = 0;
        int len = nums.length;
        for (int i = index + 1; i < len; i++) {
            if ((isUp && nums[i] < nums[index]) || (!isUp && nums[i] > nums[index])) {
                maxCount = Math.max(maxCount, 1 + cal(nums, i, !isUp));
            }
        }
        return maxCount;
    }

    //  这种思维模式真的好。
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int len = nums.length;
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[len - 1],up[len - 1]);
    }


    //dp
    // 这种dp解法太精妙了。
    public int wiggleMaxLength3(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int len = nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    //



    }
