package Leetcode;

public class Leetcode303 {
    class NumArray {
        private int[] data;
        public NumArray(int[] nums) {
            data = nums;
        }

        public int sumRange(int i, int j) {
            int num = 0;
            for (int m = i; m <= j; m++) {
                num += data[m];
            }
            return num;
        }
    }
}
