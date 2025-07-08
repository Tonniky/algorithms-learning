package interviewCompany.Huawei.aTypeCode;

import sun.net.idn.StringPrep;

import java.sql.Array;
import java.util.*;

public class cipanSort5 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] issues = in.nextLine().split(",");
//        String[] answers = in.nextLine().split(",");

        String[] issues = { "conection"};
        String[] answers = { "connection", "today"};

        System.out.println(getResult(issues, answers));

    }

    private static String getResult(String[] issues, String[] answers) {
        ArrayList<String> ans = new ArrayList<>();

        for (String issue: issues) {
            String str1 = getSortAndDistinctStr(issue);
            boolean find = false;

            for (String answer: answers) {
                String str2 = getSortAndDistinctStr(answer);
                if (str1.equals(str2)) {
                    ans.add(answer);
                    find = true;
                }
            }

            if (!find) {
                ans.add("not found");
            }
        }

        StringJoiner stringJoiner = new StringJoiner(",", "", "");
        for (String an: ans) {
            stringJoiner.add(an);
        }
        return stringJoiner.toString();
    }


    public static String getSortAndDistinctStr(String str) {
        TreeSet<Character> set = new TreeSet<>();
        for (char c: str.toCharArray()) {
            set.add(c);
        }
        return set.toString();
    }
}
