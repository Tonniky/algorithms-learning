package interviewCompany.Huawei.bTypeCode;

import java.util.Arrays;
import java.util.Scanner;

public class findMininumNumberFinder26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = (String[]) Arrays.stream(in.nextLine().split(" ")).toArray();
        Arrays.sort(str, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder result = new StringBuilder();
        if (str.length < 3) {
            for (String a: str) {
                result.append(a);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                result.append(str[i]);
            }
        }
        System.out.println(result);
    }
}
