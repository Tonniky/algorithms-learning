package Leetcode;

public class Leetcode154 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] ni = {2,2,2,0,1};
        Leetcode154 out = new Leetcode154();
        out.findMin(ni);
    }
}
