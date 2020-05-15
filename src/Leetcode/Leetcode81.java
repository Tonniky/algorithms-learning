package Leetcode;

public class Leetcode81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return false;
        int l = 0, r = len -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[l]) {
                l++;
                continue;
            }
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
        return false;
    }
    }
