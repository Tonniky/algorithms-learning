package com.company;

import java.util.*;

public class ddhi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] s = str.split(" ");

        Map<String, Integer> map = new TreeMap<>();

        for (String tt: s) {
            char[] ch = tt.toCharArray();
            Arrays.sort(ch);
            String hl = new String(ch);

            map.put(hl, map.getOrDefault(hl, 0)  + 1);
        }

        List<Map.Entry<String, Integer>> en = new ArrayList<>(map.entrySet());

        en.sort((a, b) -> {
            if (!b.getValue().equals(a.getValue())) {
                return b.getValue() - a.getValue();
            } else {
                return a.getKey().length() - b.getKey().length() != 0 ? a.getKey().length() - b.getKey().length() : a.getKey().compareTo(b.getKey());
            }
        });

        StringJoiner sb = new StringJoiner(" ");
        for (Map.Entry<String, Integer> entry: en) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.add(entry.getKey());
            }
        }
        System.out.println(sb);
    }
}
