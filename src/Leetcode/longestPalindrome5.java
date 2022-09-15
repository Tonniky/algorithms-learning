package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class longestPalindrome5 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        char[] ch = s.toCharArray();
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j = l + i - 1;
                if (j >= len) {
                    break;
                }

                if (ch[i] != ch[j]) {
                    dp[i][j] = false;
                } else {
                    if (l < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //
                if (dp[i][j] == true && l > maxLen) {
                    maxLen = l;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //
    public static String longestPalindrome1(String s) {
        if (s == null) {
            return "";
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int left = 0, right = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            int len1 = getLengthAround(s, i, i, len);
            int len2 = getLengthAround(s, i, i + 1, len);
            maxLen = Math.max(len1, len2);
            if (maxLen > right - left) {
                right = i + maxLen / 2;
                left = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    public static int getLengthAround(String s, int l, int r, int len) {
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    // monacher 算法
    public String longestPalindrome2(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            // 执行力很强
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }

    public String longestPalindrome3(String s) {
        int max_left=0,max_right=-1;
        char[] ch = s.toCharArray();
        for(int i=0; i<s.length();++i){
            int left=i,right=i;
            while(left >= 0 && ch[left] == ch[i]) --left;
            while(right<= s.length()-1&& ch[right] == ch[i]) ++right;
            while(left >= 0&&right<= ch.length - 1 && ch[left] == ch[right] ){--left;++right;}
            if(max_right - max_left < right - left){
                max_left = left;
                max_right = right;
            }
        }
        return s.substring(max_left+1,max_right-max_left-1);
    }


    public static void main(String[] args) {
        String test = "ahache";
        longestPalindrome1(test);

        longestPalindrome5 test2 = new longestPalindrome5();
        test2.longestPalindrome2(test);
    }
}
