package Leetcode;

public class Leetcode214 {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        char[] chas = s.toCharArray();
        int[][] dp = getDP(chas);  //首先求出需要添加的元素数量
        char[] res = new char[chas.length + dp[0][chas.length - 1]];  //然后新建一个新长度的字符串
        int i = 0;
        int j = chas.length -1;
        int resl = 0;
        int resr = res.length -1;
        while(i <= j){
            if(chas[i] == chas[j]){   //如果首尾相同，直接赋值
                res[resl++] = chas[i++];
                res[resr--] = chas[j--];
            } else if (dp[i][j - 1] < dp[i + 1][j]) { //看给哪一边添加值
                res[resl++] = chas[j];
                res[resr--] = chas[j--];
            } else {
                res[resl++] = chas[i];
                res[resr--] = chas[i++];
            }
        }
        return String.valueOf(res);
    }

    public int[][] getDP(char[] s){
        int[][] dp = new int[s.length][s.length];
        for (int j = 1; j < s.length; j++){
            dp[j-1][j] = s[j-1] == s[j] ? 0 : 1;  //首先统计相邻的元素
            for(int i = j - 2; i > -1; i--){
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i+1][j-1];    //如果两个数字相同的话，就不用添加字符啦
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;  //统计完整的数字
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String s = "aacecaaa";
        Leetcode214 out = new Leetcode214();
        out.shortestPalindrome(s);
    }
}
