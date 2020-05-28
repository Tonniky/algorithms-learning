package Leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Leetcode151 {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }
    }
