package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        HashSet<String> set = new HashSet<>();
        HashSet<String> out = new HashSet<>();
        for (int i = 0; i <= n - i + 1; i++) {
            String temp = s.substring(i, i + L);
            if(set.contains(temp)) out.add(temp);
            set.add(temp);
        }
        return new ArrayList<>(out);
    }
    }
