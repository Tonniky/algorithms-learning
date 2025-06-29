package interviewCompany.Huawei.bTypeCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class evaluate27 {

    private static long evaluate(String input) {
        int n = input.length();
        int maxStart = -1, maxLen = 0;
        int start = -1;
        boolean expectDigit = true;

        for (int i = 0; i <= n; i++) {
            char c = (i < n) ? input.charAt(i) : 'X';
            if (Character.isDigit(c)) {
                if (start == -1) start = i;
            } else if ((c == '+' || c == '-' || c == '*') && !expectDigit) {
                expectDigit = true;
            } else {
                if (start != -1 && !expectDigit) {
                    int len = i - start;
                    if (len > maxLen) {
                        maxStart = start;
                        maxLen = len;
                    }
                }
                start = -1;
                expectDigit = true;
            }
        }
        if (maxLen == 0) return 0;
        return 1;
    }

    private static long evalExpr(String expr) {
        Deque<Long> stack = new ArrayDeque<>();
        char op = '+';
        long num = 0;

        for (int i = 0; i <= expr.length(); i++) {
            char c = (i < expr.length()) ? expr.charAt(i) : '+';

        }
        return 1;
    }

}
