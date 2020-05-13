package Leetcode;

public class Leetcode70 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        int pre = 1;
        int cur = 1;
        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = pre + cur;
            pre = cur;
            cur = next;
        }
        return next;
    }

    public static void main(String[] args) {
        Leetcode70 out = new Leetcode70();
        out.climbStairs(3);
    }
    }
