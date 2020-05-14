package Leetcode;

public class Leetcode75 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int zero = 0, two = 0;
        int len = nums.length;
        for (int i =0; i < len; i++) {
            if (nums[i] == 0)
               zero++;
            if (nums[i] == 2)
                two++;
        }
        for(int i = 0; i < zero; i++) {
            nums[i] = 0;
        }
        for(int i = zero; i < len - two; i++) {
            nums[i] = 1;
        }
        for (int j = len - two - 1; j < len; j++) {
            nums[j] = 2;
        }
    }

    public void sortColors1(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }


    public static void main(String[] args) {
        Leetcode75 test = new Leetcode75();
        int[] param = {1,0,2,2,1,1,0};
        test.sortColors(param);
    }
}
