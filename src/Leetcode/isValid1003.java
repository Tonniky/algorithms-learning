package Leetcode;

import java.util.Stack;

public class isValid1003 {


       public boolean isValid1(String s) {
            boolean isTrue = true;
            String t = "";
            while(isTrue) {
                if (s.length() == 0) break;
                t = s.replaceAll("abc", "");
                if (t.length() == s.length()) isTrue = false;
                else s = t;
            }
            return s.length() == 0;
       }


    public boolean isValid3(String s) {
           Stack<Character> stack = new Stack<>();
           for (char c : s.toCharArray()) {
               switch (c) {
                   case 'a':
                       stack.push(c);
                       break;
                   case 'b':
                       if (!stack.isEmpty() && stack.peek() == 'a') {
                           stack.push(c);
                       } else {
                           return false;
                       }
                       break;

                   case 'c':
                       if (!(stack.size() >= 2 && stack.pop() == 'b' && stack.pop() == 'c')) {
                           return false;
                       }
               }
           }
        return stack.isEmpty();
    }



    public static void main(String[] args) {
        isValid1003 isValid1003 = new isValid1003();
        isValid1003.isValid3("abc");
    }

}
