package Leetcode;

public class Leetcode33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;
        int l = 0, r = len -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            if(nums[l] <= nums[mid]) {
                if(nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode33 out = new Leetcode33();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int res = out.search(nums,target);
        res = res;
    }
    }
