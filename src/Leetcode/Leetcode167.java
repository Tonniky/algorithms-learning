package Leetcode;

public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] res = {-1, -1};
        if(len < 2 || numbers == null) {
            return res;
        }
        int left = 0, right = len - 1;
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if(numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
