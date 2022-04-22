package Leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class isValid20 {
    public boolean isValid(String s) {
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                chars[index++] =s.charAt(i);
            } else if(index==0){
                return false;
            } else if(s.charAt(i)=='}' && chars[index-1]=='{'){
                index--;
            } else if(s.charAt(i)==']' && chars[index-1]=='['){
                index--;
            } else if(s.charAt(i)==')' && chars[index-1]=='('){
                index--;
            } else {
                return false;
            }
        }
        return index==0;
    }

    // 是否
    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                // pairs
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


    public boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']','[');
        map.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid20 isValid20 = new isValid20();
        isValid20.isValid1("{[]}");
    }

}
