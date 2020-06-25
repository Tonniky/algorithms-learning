package Leetcode;

public class Leetcode477 {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int num = 0;
        for (int i = 0; i < len - 1; i++) {
            num += hamingDistance(nums[i], nums[i + 1]);
        }
        return num;
    }

    public int hamingDistance (int left, int right) {
        int sum = 0;
        while( !(left == 0 && right == 0) ) {
            int lp = left % 2;
            int rp = right % 2;
            if (lp != rp)
                sum++;
            lp = lp / 2;
            rp = rp / 2;
        }
        return sum;
    }

    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-","");
        S = S.toUpperCase();
        int stLen = S.length()%K == 0 ? K : S.length() - S.length()/K*K;
        StringBuffer str = new StringBuffer(S);
        for(int i = stLen; i < str.length(); i = i+K+1){
            str = str.insert(i,"-");
        }
        return str.toString();
    }

    }
