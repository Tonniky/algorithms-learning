package Leetcode;

import java.util.*;

public class replaceWords648 {


    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dic = new HashSet<>();
        for (String s: dictionary) {
            dic.add(s);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dic.contains(word.substring(0, j + 1))) {
                    words[i] = word.substring(0, j + 1);
                }
            }
        }
        return String.join( " ",words);
    }

    class Solution {


        //
        public String replaceWords(List<String> dictionary, String sentence) {
            Trie trie = new Trie();
            for (String word : dictionary) {
                Trie cur = trie;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    cur.children.putIfAbsent(c, new Trie());
                    cur = cur.children.get(c);
                }
                cur.children.put('#', new Trie());
            }
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                words[i] = findRoot(words[i], trie);
            }
            return String.join(" ", words);
        }

        // 
        public String findRoot(String word, Trie trie) {
            StringBuffer root = new StringBuffer();
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children.containsKey('#')) {
                    return root.toString();
                }
                if (!cur.children.containsKey(c)) {
                    return word;
                }
                root.append(c);
                cur = cur.children.get(c);
            }
            return root.toString();
        }
    }

    class Trie {
        Map<Character, Trie> children;

        public Trie() {
            children = new HashMap<Character, Trie>();
        }
    }



    }
