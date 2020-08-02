package Leetcode;

public class Leetcode132 {
    public boolean check( String str, int start, int end)
    {
        while (start < end)
        {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }
    //
    public int minCut(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1];
        for (int i = 1; i < len; ++i)
            dp[i + 1] = dp[i] + 1;
        dp[0] = -1;
        for (int i = 0; i < len; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (check(s, j, i))
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
            }
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }
        return dp[len];
    }


}
