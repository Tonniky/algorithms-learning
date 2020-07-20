package Leetcode;

public class maxArea11 {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0,j=height.length-1;i<j;) {
            int minH = height[i]<height[j]?height[i++]:height[j--];
            max = Math.max(max,minH*(j-i+1));
        }
        return max;
    }
}
