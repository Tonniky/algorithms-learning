package hot100;

public class maxArea11 {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    private static int maxArea(int[] height) {
        int n = height.length, left = 0, right = n - 1;
        int maxLen = 0;
        while (left < right) {
            int maxValue = Math.min(height[left], height[left]) * (right - left);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            maxLen = Math.max(maxLen, maxValue);
        }
        return maxLen;
    }
}
