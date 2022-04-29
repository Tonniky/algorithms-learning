package Leetcode;

import java.util.Stack;

public class asteroidCollision735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast: asteroids) {
            collision: {
                // 行星使用
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) { //
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }

    public int[] asteroidCollision1(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        int len = asteroids.length;
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                if (asteroids[i] > 0) {
                    stack.push(asteroids[i]);
                } else {
                    int value = stack.peek();
                    if (value < 0) {
                        stack.push(asteroids[i]);
                    } else { // value > 0
                        while(!stack.isEmpty()) {
                            int top = stack.pop();
                            if (top > 0) {
                                if (top > Math.abs(asteroids[i])) {
                                    stack.push(top);
                                    break;
                                } else if (top == Math.abs(asteroids[i])) {
                                    break;
                                } else {
                                    continue;
                                }
                            } else {
                                stack.push(top);
                                stack.push(asteroids[i]);
                            }
                        }
                    }
                }
            }
        }

        int stackSize = stack.size();
        if (stack.size() == 0) {
            return new int[]{};
        } else {
            int[] res = new int[stackSize];
            while (!stack.isEmpty()) {
                res[--stackSize] = stack.pop();
            }
            return res;
        }
    }

    public int[] asteroidCollision2(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[]{};
        }
        int len = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            boolean isSure = true;
            while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0 && isSure == true) {
                if (stack.peek() > -asteroids[i]) {
                    isSure = false;
                    break;
                } else if (stack.peek() == -asteroids[i]) {
                    isSure = false;
                    stack.pop();
                    break;
                } else {
                    stack.pop();
                    continue;
                }
            }
            if (isSure == true) {
                stack.push(asteroids[i]);
            }
        }

        if (stack.isEmpty()) {
            return new int[]{};
        }
        int k = stack.size();
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }


        public static void main(String[] args) {
        asteroidCollision735 asteroidCollision735 = new asteroidCollision735();
        asteroidCollision735.asteroidCollision2(new int[]{-2,-2,1,-2});
    }
}
