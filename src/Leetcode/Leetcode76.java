//package Leetcode;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Leetcode76 {
//    //时间复杂度和空间复杂度都为：O(s + t)
//    public String minWindow(String s, String t) {
//        if (s.length() == 0 || t.length() == 0) {
//            return "";
//        }
//        HashMap<Character, Integer> t_total = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//           int num = t_total.getOrDefault(t.charAt(i),0);
//           t_total.put(t.charAt(i), num + 1);
//        }
//        int l = 0, r = 0;
//        int require = t_total.size();
//        int curr = 0;
//        HashMap<Character, Integer> s_total = new HashMap<>();
//        int record[] = {-1, 0, 0};
//        while (r < s.length()) {
//           int ss = s_total.getOrDefault(s.charAt(r),0);
//           s_total.put(s.charAt(r),ss +1);
//           if(t_total.containsKey(s.charAt(r)) && s_total.get(s.charAt(r)).equals(t_total.get(s.charAt(r)))) {
//               curr ++;
//           }
//           while (l <= r && curr == require) {
//               if (record[0] == -1 || r - l + 1 < record[0]) {
//                   record[0] = r - l + 1;
//                   record[1] = l;
//                   record[2] = r;
//               }
//               s_total.put(s.charAt(l), s_total.get(s.charAt(l)).intValue() - 1);
//               if (t_total.containsKey(s.charAt(l)) && s_total.get(s.charAt(l)).intValue() < t_total.get(s.charAt(l)).intValue()) {
//                   curr--;
//               }
//               l++;
//           }
//           r++;
//        }
//        return record[0] == -1 ? "" : s.substring(record[1],record[2] + 1);
//    }
//
//    public String minWindow1(String s, String t) {
//        if (s.length() == 0 || s.length() == 0) {
//            return "";
//        }
//        HashMap<Character,Integer> t_total = new HashMap<>();
//        for (int i =0; i < t.length(); i++) {
//            int num = t_total.getOrDefault(t.charAt(i), 0);
//            t_total.put(t.charAt(i), num + 1);
//        }
//        int l = 0, r = 0;
//        int require = t_total.size();
//        int cur = 0;
//        int[] record = {-1, 0, 0};
//        List<Pair<Integer,Character>> newS = new ArrayList<>();
//        HashMap<Character,Integer> s_total = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (t_total.containsKey(s.charAt(i))) {
//                newS.add(new Pair<>(i,s.charAt(i)));
//            }
//        }
//        while (r < newS.size()) {
//            char ch = newS.get(r).getValue();
//            s_total.put(ch, s_total.getOrDefault(ch,0) + 1);
//            if (s_total.get(ch).equals(t_total.get(ch))) {
//                cur++;
//            }
//            while (require == cur) {
//                int lTemp = newS.get(l).getKey();
//                int rTemp = newS.get(r).getKey();
//                if (record[0] == -1 || record[0] > rTemp - lTemp + 1) {
//                    record[0] = rTemp - lTemp + 1;
//                    record[1] = lTemp;
//                    record[2] = rTemp;
//                }
//                char leftValue = newS.get(l).getValue();
//                s_total.put(newS.get(l).getValue(), s_total.get(leftValue) - 1);
//                if (s_total.get(leftValue).intValue() < t_total.get(leftValue).intValue()) {
//                    cur--;
//                }
//                l++;
//            }
//            r++;
//        }
//        return record[0] == -1 ? "" : s.substring(record[1], record[2] + 1);
//    }
//
//        public static void main(String[] args) {
//        Leetcode76 out = new Leetcode76();
//        String word1 = "ADOBECODEBANC";
//        String word2 = "ABC";
//        out.minWindow1(word1, word2);
//    }
//
//
//
//    }
