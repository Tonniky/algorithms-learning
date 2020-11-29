package Leetcode;

public class findUnsortedSubarray581 {
    public static int findUnsortedSubarray(int[] nums) {
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if(nums[i] > nums[j]) {
                    int temp = i;
                    start = start < temp ? start : temp;
                }
            }
        }

        for (int k = len - 1; k > 0; k--) {
            for (int m = k - 1; m >= 0; m--) {
                if (nums[k] < nums[m]) {
                    int temp2 = k;
                    end = end > temp2 ? end : temp2;
                }
            }
        }

        if (start > len) {
            return 0;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] m = {1,2,3,4};
        findUnsortedSubarray(m);
    }
}
