package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class calculate227 {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public int calculate1(String s) {
        Deque<Integer> deque = new LinkedList<>();
        int num = 0;
        char preSign = '+';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch(preSign) {
                    case '+':
                        deque.push(num);
                        break;
                    case '-':
                        deque.push(-num);
                        break;
                    case '*':
                        deque.push(deque.pop() * num );
                        break;
                    case '/':
                        deque.push(deque.pop() / num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!deque.isEmpty()) {
            res += deque.pop();
        }
        return res;
    }



    public static void main(String[] args) {
        calculate227 calculate227 = new calculate227();
        calculate227.calculate1("3+5 / 2 ");
    }

}
