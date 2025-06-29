package interviewCompany.Huawei.bTypeCode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class movePerson9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        if (!s.matches("[0-9\\s]+")) {
            System.out.println("[]");
            return;
        }

        int[] heights = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int i = 0, j = 1;
        while (j < heights.length) {
            if (heights[i] != heights[j] && (heights[i] > heights[j]) != (i % 2 == 0)) {
                int tmp = heights[i];
                heights[i] = heights[j];
                heights[j] = tmp;
            }

            i++;
            j++;
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int h : heights) {
            sj.add(String.valueOf(h));
        }
        System.out.println(sj.toString());
    }
}
