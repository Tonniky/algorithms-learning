package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class clumsy1006 {

    // 中间
    public int clumsy(int n) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(n);
        n--;

        int index = 0; // 用于控制乘、除、加、减
        while (n > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * n);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / n);
            } else if (index % 4 == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }
            index++;
            n--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
