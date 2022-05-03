package Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class longestWPI1124 {

    public int longestWPI(int[] hours) {

        int n = hours.length;
        int[] score = new int[n];
        for (int i=0;i<n;i++) {
            if (hours[i] > 8) score[i] = 1;
            else score[i] = -1;
        }
        int[] presum = new int[n + 1];
        presum[0] = 0;
        for (int i=1;i<n+1;i++) {
            presum[i] = presum[i - 1] + score[i - 1];
        }
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i=1;i<n+1;i++) {
            if (stack.isEmpty() || presum[stack.peek()] > presum[i]) {
                stack.push(i);
            }
        }
        for (int i=n+1;i>=0;i--) {
            while(!stack.isEmpty() && presum[i] > presum[stack.peek()]) {
                result = Math.max(result, i - stack.pop());
            }
        }
        return result;
    }



    public int longestWPI1(int[] hours) {
        int len = hours.length;
        int[] score = new int[len];
        for (int i = 0; i < len; i++) {
            if (hours[i] > 8) {
                score[i] = 1;
            } else {
                score[i] -= 1;
            }
        }
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + score[i - 1];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || preSum[i] < preSum[stack.peek()]) {
                stack.push(i);
            }
        }
        //
        int res = 0;
        for (int i = len ; i >= 0; i--) {
            while(!stack.isEmpty() && preSum[i] > preSum[stack.peek()] ) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }

    public int longestWPI2(int[] hours) {
        int n = hours.length;
        int[] score = new int[n];
        for (int i=0;i<n;i++) score[i] = hours[i] > 8 ? 1 : -1;

        int[] presum = new int[n + 1];
        presum[0] = 0;
        for (int i=1;i<n+1;i++) presum[i] = presum[i - 1] + score[i - 1];

        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        for (int i=1;i<n;i++) {
            if (stack.isEmpty() || presum[stack.peekLast()] > presum[i]) {
                stack.addLast(i);//栈中索引指向的元素严格单调递减
            }
        }
        for (int i=n;i>=0;i--) {//从后往前遍历 presum 数组
            while(!stack.isEmpty() && presum[i] > presum[stack.peekLast()]) {//说明栈顶索引到i位置的和是大于0的，是表现良好的时间段
                result = Math.max(result, i - stack.pollLast());//与栈顶索引指向元素比较，如果相减结果大于 0，则一直出栈，直到不大于 0 为止，然后更新当前最大宽度
            }
        }
        return result;
    }

    public static void main(String[] args) {
        longestWPI1124 longestWPI1124 = new longestWPI1124();
        longestWPI1124.longestWPI1(new int[]{9,9,6,0,6,6,9});
    }


    }
