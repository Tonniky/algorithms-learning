package Leetcode;

public class smallestSubsequence1081 {

    // 最小
    public String smallestSubsequence(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) { // vis 等于 false
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) { //
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }


    public String smallestSubsequence1(String s) {
        int[] num = new int[26];
        boolean[] vim = new boolean[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            num[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < len; j++) {
            char ch = s.charAt(j);
            if (!vim[ch - 'a']) {
                while ( sb.length() > 0 && sb.charAt(sb.length() - 1) > ch ) {
                    if ( num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vim[s.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                sb.append(ch);
                vim[ch - 'a'] = true;
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
}


        public static void main(String[] args) {
        smallestSubsequence1081 smallestSubsequence1081 = new smallestSubsequence1081();
        smallestSubsequence1081.smallestSubsequence1("cbacdcbc");
    }

}
