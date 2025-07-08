package interviewCompany.Huawei.aTypeCode;

import java.util.Arrays;

public class shitupu18 {
    public static void main(String[] args) {
        String content = "qweeebaewqd";
        String word = "qew";
        System.out.println(getResult(content, word));
    }

    private static int getResult(String content, String word) {
        if (content.length() < word.length()) {
            return 0;
        }

        char[] tmp = word.toCharArray();
        Arrays.sort(tmp);

        String sorted_word = new String(tmp);

        int ans = 0;
        int maxI = content.length() - word.length();
        int len = word.length();

        for (int i = 0; i <= maxI; i++) {
            char[] window = content.substring(i ,i + len).toCharArray();
            Arrays.sort(window);

            if (sorted_word.equals(new String(window))) {
                ans++;
            }
        }

        return ans;
    }
}
