package Leetcode;

public class countSubstrings647 {
    public int countSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int num = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int l = i * 2, r = i * 2 + i % 2;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(countSubString1(str));
    }

    public static int countSubString1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int num = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int l = i/2, r = i / 2 + i % 2;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                num++;
            }
        }
        return num;
    }


    public int countSubstrings2(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }





}
