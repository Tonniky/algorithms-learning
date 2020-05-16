package Leetcode;

public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int xPoint = m - 1;
        int yPoint = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if(xPoint == -1) {
                nums1[i] = nums2[yPoint--];
            } else if(yPoint == -1) {
                nums1[i] = nums1[xPoint--];
            }else if (nums2[xPoint] >= nums1[xPoint]) {
                nums1[i] = nums2[yPoint--];
            } else {
                nums1[i] = nums1[xPoint--];
            }
        }
    }
    }
