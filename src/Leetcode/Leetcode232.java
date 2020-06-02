package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode232 {
    class MyQueue {
        Queue<Integer> q1;
        Queue<Integer> q2;
        /** Initialize your data structure here. */
        public MyQueue() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            q1.add(x);
            while(!q1.isEmpty()) {
                q2.add(q1.poll());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
           return q2.poll();
        }

        /** Get the front element. */
        public int peek() {
           return q2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
           return q2.isEmpty();
        }
    }

}
