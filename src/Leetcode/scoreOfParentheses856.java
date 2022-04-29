package Leetcode;

import java.util.Stack;

public class scoreOfParentheses856 {
    public int scoreOfParentheses(String s) {
        return score(s, 0, s.length());
    }


    public int score(String s, int i, int j) {
        int ans = 0, fen = 0;
        for (int k  = i;  k < j; k++) {
            fen += s.charAt(k) == '(' ? 1 : - 1;
            if (fen == 0) {
                if (k - i == 1) {
                    ans++;
                } else {
                    ans += 2 * score(s, k + 1, j);
                }
                i = k + 1;
            }
        }
        return ans;
    }

    public int scoreOfParentheses1(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char m : S.toCharArray()) {
            if (m == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        scoreOfParentheses856 scoreOfParentheses856 = new scoreOfParentheses856();
        scoreOfParentheses856.scoreOfParentheses("()");
    }
}
