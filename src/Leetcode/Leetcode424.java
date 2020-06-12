package Leetcode;

public class Leetcode424 {
    private int[] map = new int[26];
    public int characterReplacement(String s, int k) {
        if ( s == null) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int left = 0;
        int right = 0;
        int lenMax = 0;
        for (right = 0; right < ch.length; right++) {
            int index = ch[right] - 'A';
            map[index]++;
            lenMax = Math.max(lenMax, map[index]);
            if (right - left > lenMax + k) {
                map[ch[left] - 'A']--;
                left++;
            }
        }
        return ch.length - left;
    }
    }
