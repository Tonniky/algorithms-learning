package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class recordSpaces5519 {
    public String reorderSpaces(String text) {
        char[] ch = text.toCharArray();
        int len = ch.length;
        int count_no = 0;
        for (int i = 0; i < len; i++) {
            if (ch[i] == ' ') {
                count_no++;
            }
        }
        char[] newCh = text.trim().toCharArray();
        List<String> temp = new ArrayList<>();
        String str = new String();
        boolean flag = false;
        for (int i = 0; i < newCh.length; i++) {
            if (ch[i] == ' ' && flag == false) {
                temp.add(str);
                str = new String();
                flag = true;
            }
            if (ch[i] != ' ' && flag == true) {
                flag = false;
                str += String.valueOf(ch[i]);
            }
        }
        int word_count = temp.size();
        int dis = 0;
        int loss = 0;
        if (word_count > 1) {
            dis = (len - count_no) / (word_count - 1);
            loss = (len - count_no) % (word_count - 1);
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(word_count!=0) {
            res.append(temp.get(i++));
            word_count--;
            if (word_count != 0) {
                res = addWord(res, dis);
            }
        }
        if (loss != 0) {
            res = addWord(res, loss);
        }
        return res.toString();
    }


    public StringBuilder addWord(StringBuilder str, int count) {
        for(int i = 0; i < count; i++) {
            str.append(' ');
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "  this   is  a sentence ";

    }
    }
