package Leetcode;

public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int index = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i-1] == nums[i]) {
                index++;
                if(index > 2) {
                    this.reLocation(nums,i,len);
                    i--;
                    len--;
                }
            } else {
                index = 1;
            }
        }
        return len;
    }

    public int[] reLocation(int[] nums, int i, int len) {
        for(int m = i; m < len; m++) {
            nums[m-1] = nums[m];
        }
        return nums;
    }

    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        int index = 1;
        int j = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i-1] == nums[i]) {
                index++;
            } else {
                index = 1;
            }
            if(index <= 2) {
                nums[j++] = nums[i];
            }
        }
        return len;
    }


}
