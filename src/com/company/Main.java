package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        String s = "cda";
//        char[] ch = s.toCharArray();
//        Arrays.sort(ch);
//        System.out.println(ch);


        String str = "this is an apple";
        String[] newStr = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        int n = newStr.length;
        String[] tt = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = newStr[i];
            char[] ch = temp.toCharArray();
            Arrays.sort(ch);
            String ns = String.valueOf(ch);
            map.put(ns, map.getOrDefault(ns, 0) + 1);
            tt[i] = ns;
        }

        String[] mm = new String[n];
        int max = 0;
        String[] visited = new String[n];
        for (int j = 0; j < n; j++) {
            if (map.get(tt[j]) > max) {
                max = map.get(tt[j]);
            }
        }

        for (String m: map.keySet()) {

        }



    }
}
