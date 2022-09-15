package Leetcode;

public class jump45 {

    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[position] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


        public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    public int jump1(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        jump45 jump45 = new jump45();
        jump45.jump1(new int[] {2,3,1,1,4});
    }

    // 跳跃游戏
    public int jump3(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxJump = 0;
        int step = 0;
        for (int i = 0; i < len - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (end == i) {
                end = maxJump;
                step++;
            }
        }
        return step;
    }

    public int jump5(int[] nums) {
        int ans = 0;
        int start = 0;
        int end = 1;
        int steps = 0;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, nums[i] + i);
            }
            start = end;
            end = maxPos + 1;
            steps++;
        }
        return steps;
    }


}
