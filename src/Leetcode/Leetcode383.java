package Leetcode;

public class Leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length())
            return  false;
        int[] cap = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, cap[c - 'a']);
            if (index == -1)
                return false;
            cap[c - 97] = index + 1;
        }
        return true;
    }
    }
