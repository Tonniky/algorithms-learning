package Leetcode;

import java.util.Stack;

public class MinStack155 {
    class MinStack {
        public Stack<Integer> min_stack;
        public Stack<Integer> s_stack;
        /** initialize your data structure here. */
        public MinStack() {
            min_stack = new Stack<>();
            s_stack = new Stack<>();
            min_stack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            min_stack.push(Math.min(min_stack.peek(),x));
        }

        public void pop() {
            min_stack.pop();
            s_stack.pop();
        }

        public int top() {
            return s_stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
