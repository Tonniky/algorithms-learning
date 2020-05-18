package Leetcode;

public class Leetcode91 {

    public int numDecodings(String s) {
        char[] chas = s.toCharArray();
        if (chas.length == 0 || Integer.parseInt(String.valueOf(chas[0])) == 0) {
            return 0;
        }
        if (chas.length == 1) {
            return s.length();
        }
        int len = chas.length;
        int[] res= new int[len];
        res[0] = 1;
        if (Integer.parseInt(String.valueOf(chas[0])) == 0 ||
                (Integer.parseInt(String.valueOf(chas[0])) > 2 && Integer.parseInt(String.valueOf(chas[1])) == 0)) {
            return 0;
        } else if((Integer.parseInt(String.valueOf(chas[0])) <= 2 && Integer.parseInt(String.valueOf(chas[1])) == 0) ||  (Integer.parseInt(String.valueOf(chas[0])) == 2  &&Integer.parseInt(String.valueOf(chas[1])) > 6
        ) || (Integer.parseInt(String.valueOf(chas[0])) > 2 )) {
            res[1] = 1;
        } else {
            res[1] = 2;
        }
        for (int i = 2; i < len; i++) {
            if((Integer.parseInt(String.valueOf(chas[i])) == 0 && Integer.parseInt(String.valueOf(chas[i-1])) == 0) ||
                    (Integer.parseInt(String.valueOf(chas[i-1])) > 2 && Integer.parseInt(String.valueOf(chas[i])) == 0)) {
                return 0;
            }else if (Integer.parseInt(String.valueOf(chas[i-1])) >= 2 && Integer.parseInt(String.valueOf(chas[i])) > 6 || (Integer.parseInt(String.valueOf(chas[i-1])) == 0) ) {
                res[i] = res[i - 1];
            } else if ( Integer.parseInt(String.valueOf(chas[i])) == 0) {
                res[i] = res[i-2];
            }
            else {
                res[i] = res[i-1] + res[i - 2];
            }
        }
        return res[len - 1];
    }

    public int numDecodings1(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = arr[0]=='0'?0:1;
        if(s.length()<=1) return dp[1];
        for(int i=2;i<=s.length();i++){
            int n = (arr[i-2]-'0')*10+(arr[i-1]-'0');
            if(arr[i-1]=='0' && arr[i-2]=='0'){
                return 0;
            }else if(arr[i-2]=='0'){
                dp[i] = dp[i-1];
            }else if(arr[i-1]=='0'){
                if(n>26) return 0;
                dp[i] = dp[i-2];
            }else if(n>26){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args) {
        String s = "227";
        Leetcode91 out = new Leetcode91();
        out.numDecodings(s);
    }
    }
