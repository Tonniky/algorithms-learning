package Leetcode;

import java.util.Stack;

public class Leetcode155 {

    public class MinStack {
        Stack<Integer> data;
        Stack<Integer> helper;

        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        public void push (int x) {
            data.push(x);
            if (helper == null || helper.peek() >= x) {
                helper.push(x);
            } else {
                helper.push(helper.peek());
            }
        }

        public void pop() {
            data.pop();
            helper.pop();
        }

        public int top () {
            return data.peek();
        }

        public int getMin() {
            return helper.peek();
        }
    }
}
