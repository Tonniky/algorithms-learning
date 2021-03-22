package group_interview.beikezhaofang;

import java.util.Stack;

public class StackToList {



    public class LinkedList {
        public Stack<Integer> stack1;
        public Stack<Integer> stack2;

    public  LinkedList() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    public void add(int val) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(val);
    }

    public void remove() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.pop();
    }

    }

}
