package Leetcode;

public class increasingTriplet334 {

    public static void main(String[] args) {
        increasingTriplet334 increasingTriplet334 = new increasingTriplet334();
        increasingTriplet334.increasingTriplet1(new int[] {1,2,3,4,5});
    }

    public boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(nums[i], leftMin[i - 1]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (leftMin[i] < nums[i] && rightMax[i + 1] > nums[i]) {
                return true;
            }
        }
        return false;
    }



        public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }


}
