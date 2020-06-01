package Leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode225 {
    class MyStack {

        /** Initialize your data structure here. */
        public MyStack() {
        }
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        int top;

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
            top = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while (q1.size() > 1) {
                top = q1.poll();
                q2.add(top);
            }
            int value = q1.remove();
            Queue<Integer> temp = q1;
            q2 = q1;
            q1 = temp;
            return value;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }


    class MyStack1 {
        Queue<Integer> q1;
        /** Initialize your data structure here. */
        public MyStack1() {
            q1 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
            for (int i = 1; i < q1.size(); i++) {
                q1.add(q1.remove());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.remove();
        }

        /** Get the top element. */
        public int top() {
            return q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

}
