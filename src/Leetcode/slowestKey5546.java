package Leetcode;
import java.util.*;
public class slowestKey5546 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] ch = keysPressed.toCharArray();
        int len = releaseTimes.length;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        Stack<Character> stack = new Stack<Character>();
        map.put(ch[0],releaseTimes[0]);
        stack.push(ch[0]);
        for (int i = 1; i < len; i++) {
            int tempTime = releaseTimes[i] - releaseTimes[i - 1];
            if (!map.containsKey(ch[i]) || map.get(ch[i]) < tempTime) {
                map.put(ch[i], tempTime);
            }
            while(!stack.isEmpty() && map.get(stack.peek()) < tempTime) {
                stack.pop();
            }
            if (stack.isEmpty() || map.get(stack.peek()) == tempTime) {
                stack.push(ch[i]);
            }
        }
        return getKey(stack);
    }

    public char getKey(Stack<Character> ch) {
        if (ch.size() == 1){
            return ch.pop();
        }
        char temp = ch.pop();
        while(!ch.isEmpty()) {
            char l = ch.pop();
            if (temp - '0' < l - '0' ) {
                temp = l;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        slowestKey5546 test = new slowestKey5546();
        int[] releaseTimes = {4,29,34,48,67,74,77,79,95};
        String keysPressed = "bompxoxbu";
        test.slowestKey(releaseTimes, keysPressed);
    }
}
