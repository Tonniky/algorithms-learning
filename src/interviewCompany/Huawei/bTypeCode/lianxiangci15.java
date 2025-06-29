package interviewCompany.Huawei.bTypeCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class lianxiangci15 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String sentence = br.readLine();
//        String prefix = br.readLine();

        String sentence = "I love you";
        String prefix = "yo";

        sentence = sentence.replace("[^a-zA-Z", " ");
        Set<String> wordSet = new TreeSet<>();
        String[] words = sentence.split("\\s+");
        for (String word: words) {
            wordSet.add(word);
        }
        StringBuilder ans = new StringBuilder();
        for (String s: wordSet) {
            if (s.startsWith(prefix)) {
                ans.append(s).append(" ");
            }
        }
        if (ans.length() > 0) {
            System.out.println(ans.toString().trim());
        } else {
            System.out.println(prefix);
        }
    }
}
