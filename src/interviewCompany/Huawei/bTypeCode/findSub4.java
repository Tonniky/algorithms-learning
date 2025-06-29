package interviewCompany.Huawei.bTypeCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class findSub4 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String s1 = sc.next();
//        String s2 = sc.next();

        String s1 = "123admyffc79pt";
        String s2 = "ssyy";

        System.out.println(findSub1(s1, s2));
    }

    private static String findSub(String s1, String s2) {
        String[] validParts = s1.split("[0-9a-f]");

        int targetCount = uniqueCount(s2);

        String result = "Not Found";
        int maxUnique = 0;

        for (String part: validParts) {
            if (!part.isEmpty()) {
                int uniqueInPart = uniqueCount(part);

                if (uniqueInPart <= targetCount) {
                    if (uniqueInPart > maxUnique || (uniqueInPart == maxUnique && part.compareTo(result) > 0)) {
                        result = part;
                        maxUnique = uniqueInPart;
                    }
                }
            }
        }

        return result;
    }

    private static int uniqueCount(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c: s.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }


    private static String findSub1(String s1, String s2) {
        String[] str = s1.split("[0-9a-f]");

        int num = getUniqueNum(s2);

        String res = "Not Found";
        int maxNum = 0;
        for (String s: str) {
            if (!s.isEmpty()) {
                int uniqueNum = getUniqueNum(s);
                if (uniqueNum <= num) {
                    if (uniqueNum > maxNum || (uniqueNum == maxNum && s.compareTo(res) > 0)) {
                        res = s;
                        maxNum = uniqueNum;
                    }
                }
            }
        }
        return res;
    }

    private static int getUniqueNum(String s) {
        char[] c = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (Character ch: c) {
            if (!set.contains(ch)) {
                set.add(ch);
            }
        }
        return set.size();
    }
}
