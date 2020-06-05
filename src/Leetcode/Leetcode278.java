package Leetcode;

public class Leetcode278 {
    public int firstBadVersion(int n) {
        if (n == 1)
            return 1;
        int left = 1, right = n;
        while(left < right) {
            int mid = left +(right- left) / 2;
            if(isBadVersion(mid) == true) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int firstBadVersion1(int n) {
        for (int i = 1; i < n; i++) {
            if(isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }


        public boolean isBadVersion(int n){
        return true;
    }
    }
