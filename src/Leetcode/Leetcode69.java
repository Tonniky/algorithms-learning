package Leetcode;

public class Leetcode69 {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        int temp = (int)Math.exp(0.5 * Math.log(x));
        return (long)(temp + 1) * (temp + 1) <= x ? (temp + 1) : temp;
    }

    public int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int x = 8;
        Leetcode69 output = new Leetcode69();
        output.mySqrt1(2147395600);
    }
    }
