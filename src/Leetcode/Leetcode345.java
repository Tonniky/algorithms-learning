package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode345 {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] ch = s.toCharArray();
        if (s.length() < 2)
            return s;
        help(ch, 0, s.length() - 1, set);
        return String.valueOf(ch);
    }

    public void help(char[] s, int left, int right, HashSet<Character> set) {
        if (left >= right) {
            return;
        }
        if (set.contains(s[left]) && set.contains(s[right])) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        while (!set.contains(s[left])) {
            left++;
        }
        while (!set.contains(s[right])) {
            right--;
        }
        help(s, left, right, set);
    }

    public static void main(String[] args) {
        Leetcode345 out = new Leetcode345();
        out.reverseVowels("hello");
    }
    }
