package Leetcode;

public class reverseLeftWords1648 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int j = 0; j < n; j++) {
            res.append(s.charAt(j));
        }
        return res.toString();
    }
    }
