package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode500 {
    public String[] findWords(String[] words) {
        String[] str = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        if (words == null || words.length == 0)
            return words;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words.length <= 1) {

            }
            int flag = Integer.MIN_VALUE;
            for(int j = 0; j < words.length; j++) {
               if(str[j].contains(words[i].substring(0,0))) {
                   flag = j;
               }
            }
            char[] ch = words[i].toCharArray();
            int pos = -1;
            while (pos++ < ch.length - 1) {
               if(!str[flag].contains(String.valueOf(ch[pos]))) {
                   break;
               }
            }
            if(pos == ch.length - 1) {
                res.add(words[i]);
            }
        }
        return res.toArray(new String[res.size()]);
     }
    }
